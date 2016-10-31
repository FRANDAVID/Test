package mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

/**
 * HelloMongo 
 * 参考: http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/
 * @author LINWENBIN
 * @since 2015-6-6
 */
public class HelloMongo {

    /**
     * 往集合里面插入一条数据
     * @param coll
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void insertOne(MongoCollection<Document> coll){
        /*
        {
           "name" : "MongoDB",
           "type" : "database",
           "count" : 1,
           "info" : {
                       x : 203,
                       y : 102
                     }
        }
        */
        System.out.println("insertOne 插入记录之前 users集合的数量:" + coll.count());

        Document doc = new Document("name","MongoDB")
        .append("type","database").append("count", 1).append("info", new Document("x","203").append("y","102"));

        coll.insertOne(doc);

        System.out.println("insertOne 插入记录之后 users集合的数量:" + coll.count());
    }

    /**
     * 插入多条数据
     * @param coll
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void insertMany(MongoCollection<Document> coll){
        /*
         * 循环插入 {"i" : i}的document
         */
        List<Document> docs = new ArrayList<Document>();
        for(int i=0; i<10; i++){
            docs.add(new Document("i",i));
        }

        coll.insertMany(docs);

        System.out.println("insertMany 插入10条 {i:i} 记录之后 users集合的数量:" + coll.count());        
    }

    /**
     * 查询集合coll中的所有数据
     * @param coll
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void findAll(MongoCollection<Document> coll){
        MongoCursor<Document> cursor = coll.find().iterator();
        try {
            System.out.println("findAll 打印结果：");
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    /**
     * 查询满足条件的第一条数据
     * @param coll
     * @param filter
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void findSpecifyDoc(MongoCollection<Document> coll, Bson filter){
        System.out.println("findSpecifyDoc 打印结果：");
        System.out.println(coll.find(filter).first().toJson());
    }

    /**
     * 查询满足条件的文档集合
     * @param coll
     * @param filter
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void findDocs(MongoCollection<Document> coll, Bson filter){
        Block<Document> printBlock = new Block<Document>() {
             @Override
             public void apply(final Document document) {
                 System.out.println(document.toJson());
             }
        };
        System.out.println("findDocs 打印结果：");
        coll.find(filter).forEach(printBlock);
    }

    /**
     * 更新文档属性
     * @param coll        要操作的集合
     * @param criteria    要更新的文档过滤条件
     * @param newDoc    新的文档属性
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void update(MongoCollection<Document> coll, Bson criteria, Document newDoc){
        coll.updateMany(criteria, new Document("$set",newDoc));
    }

    /**
     * 删除文档
     * @param coll
     * @param criteria
     * @since 2015-6-6
     * @author LINWENBIN
     */
    public void delete(MongoCollection<Document> coll, Bson criteria){
        coll.deleteMany(criteria);
    }

    public static void main(String[] args) {
        HelloMongo helloMongo = new HelloMongo();

        //mongoClient实例本身代表着数据库的连接池
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        /**
         * Calling the getDatabase() on MongoClient does not create a database. 
         * Only when a database is written to will a database be created
         */
        MongoDatabase db = mongoClient.getDatabase("demo");
        MongoCollection<Document> users = db.getCollection("users");


        helloMongo.insertOne(users);
        helloMongo.insertMany(users);
        helloMongo.findAll(users);
        helloMongo.findSpecifyDoc(users, eq("i",5));
        helloMongo.findDocs(users, and(gt("i",6),lte("i",8)));

        helloMongo.update(users, and(gt("i",6),lte("i",8)), new Document("ii",99));
        helloMongo.findDocs(users, and(gt("i",6),lte("i",8)));

        helloMongo.delete(users, and(gt("i",6),lte("i",8)));
        helloMongo.findDocs(users, and(gt("i",6),lte("i",8)));

        //销毁
        mongoClient.dropDatabase("demo");
        //关闭数据库连接
        mongoClient.close();
    }
}