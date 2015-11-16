package enumTest;

/**
 * @Function:所有节点的类型
 * @author:Weilipeng
 * @Date:2015年8月19日
 **/
public enum NodeType {

    NULL, //(0)

    /**
     * 数据源
     */
    //
    DATA_SOURCE, //(1),

    /**
     * 数据转换
     */
    //关联数据源
    DATA_CORRELATION, //(2),

    //API, //(e.g:微博数据)
    DATA_API, //(3),

    //数据类型修改
    DATA_Type_MODIFY, //(4),

    //删除数据列
    DATA_COLUMN_DELETE, //(5),

    //删除数据行
    DATA_ROW_DELETE, //(6),

    //替换数据值
    DATA_VALUE_REPLACE, //(7),

    //数据列的分组
    DATA_COLUMN_GROUP, //(8),

    /**
     * 特征提取
     */
    SELECT_FETCH_WORD, //(9),

    //特征选取
    FEATURE_SELECT, //(10),

    //选择Label
    SELECT_LABEL, //(11),

    /*
    //基于滤波器的特征选择
    FILTER_BASED_FEATURE_SELECTION , //(),
    
    //线性判别分析
    FISHER_LINEAR_DISCRIMINANT_ANALYSIS , //(100000),
    
    //PERMUTATION_FEATURE
    PERMUTATION_FEATURE , //(100000),
    */

    /**
     * 模型预测
     */
    //模型预测
    DATA_MODEL_FORECAST, //(12),

    //13号  没有   设为null
    NULL13,

    /**
     * 模型对比
     */
    //模型对比
    DATA_MODEL_COMPARE, //(14),

    /**
     * 自动分析
     */
    //智能分析
    INTELLIGENCE_ANALYSIS, //(15),

    /**
     * 模型配置
     */
    //选择测试数据
    TEST_DATA_SELECT, //(16),

    //逻辑归回
    LOGISTIC_REGRESSION, //(17),

    //决策树
    DECISIONTREE, //(18),

    //svm
    SVM, //(19),

    //朴素贝叶斯
    NAIVEBAYES, //(20),

    //knn
    KNN,
    //(21),
   
    /*
     //决策树
    DECISIONTREE , //(100000);
    */
    //
    NULL22,
    NULL23,
    //新增加的列的名称修改
    DATA_COLUMN_NAME_MODIFY,//24
    MISS_DATA_FILL,//25 缺失数据的填充
    
    DATA_COLUMN_COPY,//26 复制列
    ;

    public static NodeType valueOf (int ordinal) {

        if (ordinal < 0 || ordinal >= values ().length) {
            throw new IndexOutOfBoundsException ("Invalid ordinal");
        }
        return values () [ordinal];
    }

}