package com.xue.springboot1.utils;

import org.junit.Test;


public class SqlUtils {

    /**
     * @param tableSchema 数据库名
     * @param tableName   表名
     * @param columnName  字段名
     * @param sql         要转换的sql语句
     * @return 修改表字段属性返回能够复用的存储过程
     */
    public static String modifyTableField(String tableSchema, String tableName, String columnName, String sql) {
        return "DROP PROCEDURE IF EXISTS modify_column_attr;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE modify_column_attr()\n" +
                "BEGIN\n" +
                "\t" + "IF EXISTS ( SELECT 1 FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "' " +
                "AND TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + columnName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL modify_column_attr();";
    }

    /**
     * @param tableSchema 数据库名
     * @param tableName   表名
     * @param columnName  字段名
     * @param sql         要转换的sql语句
     * @return 新增表字段返回能够复用的存储过程
     */
    public static String addTableField(String tableSchema, String tableName, String columnName, String sql) {
        return "DROP PROCEDURE IF EXISTS add_column;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE add_column()\n" +
                "BEGIN\n" +
                "\t" + "IF NOT EXISTS ( SELECT 1 FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "' " +
                "AND TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + columnName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL add_column();";
    }

    /**
     * @param tableSchema 数据库名
     * @param tableName   表名
     * @param columnName  旧字段名
     * @param sql         sql语句
     * @param newName     新字段名
     * @return 修改表字段名称返回能够复用的存储过程
     */
    public static String modifyTableFieldName(String tableSchema, String tableName, String columnName, String sql, String newName) {
        return "DROP PROCEDURE IF EXISTS modify_column_name;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE modify_column_name()\n" +
                "BEGIN\n" +
                "\t" + "IF EXISTS ( SELECT 1 FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "' \n" +
                "\t" + "AND TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + columnName + "' )\n" +
                "\t" + "AND NOT EXISTS ( SELECT 1 FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "'\n" +
                "\t" + "AND TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + newName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL modify_column_name();";
    }

    /**
     * @param tableSchema 数据库名
     * @param tableName   表名
     * @param columnName  字段名
     * @param sql         要转换的sql语句
     * @return 删除表字段返回能够复用的存储过程
     */
    public static String dropColumn(String tableSchema, String tableName, String columnName, String sql) {
        return "DROP PROCEDURE IF EXISTS drop_column;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE drop_column()\n" +
                "BEGIN\n" +
                "\t" + "IF EXISTS ( SELECT 1 FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "' " +
                "AND TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + columnName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL drop_column();";
    }

    /**
     * @param tableSchema 数据库名
     * @param tableName   表名
     * @param indexName   索引名
     * @param sql         sql语句
     * @return 新增索引返回能够复用的存储过程
     */
    public static String addIndex(String tableSchema, String tableName, String indexName, String sql) {
        return "DROP PROCEDURE IF EXISTS add_index;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE add_index()\n" +
                "BEGIN\n" +
                "\t" + "IF NOT EXISTS ( SELECT 1 FROM information_schema.statistics WHERE TABLE_SCHEMA = '" + tableSchema + "' " +
                "AND TABLE_NAME = '" + tableName + "' AND INDEX_NAME = '" + indexName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL add_index();";
    }

    /**
     * @param tableSchema 数据库名
     * @param tableName   表名
     * @param indexName   索引名
     * @param sql         sql语句
     * @return 删除索引返回能够复用的存储过程
     */
    public static String dropIndex(String tableSchema, String tableName, String indexName, String sql) {
        return "DROP PROCEDURE IF EXISTS drop_index;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE drop_index()\n" +
                "BEGIN\n" +
                "\t" + "IF EXISTS ( SELECT 1 FROM information_schema.statistics WHERE TABLE_SCHEMA = '" + tableSchema + "' " +
                "AND TABLE_NAME = '" + tableName + "' AND INDEX_NAME = '" + indexName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL drop_index();";
    }

    /**
     * @param tableSchema  数据库名
     * @param tableName    表名
     * @param indexName    旧索引名
     * @param sql          sql语句
     * @param newIndexName 新索引名
     * @return 修改索引名称返回能够复用的存储过程
     */
    public static String modifyIndexName(String tableSchema, String tableName, String indexName, String sql, String newIndexName) {
        return "DROP PROCEDURE IF EXISTS modify_index_name;\n" +
                "DELIMITER;;\n" +
                "CREATE PROCEDURE modify_index_name()\n" +
                "BEGIN\n" +
                "\t" + "IF EXISTS ( SELECT 1 FROM information_schema.statistics WHERE TABLE_SCHEMA = '" + tableSchema + "' \n" +
                "\t" + "AND TABLE_NAME = '" + tableName + "' AND INDEX_NAME = '" + indexName + "' )\n" +
                "\t" + "AND NOT EXISTS ( SELECT 1 FROM information_schema.statistics WHERE TABLE_SCHEMA = '" + tableSchema + "'\n" +
                "\t" + "AND TABLE_NAME = '" + tableName + "' AND INDEX_NAME = '" + newIndexName + "' )\n" +
                "THEN\n" +
                "\t" + sql + "\n" +
                "END IF;\n" +
                "END;;\n" +
                "DELIMITER;\n" +
                "CALL modify_index_name();";
    }


    @Test
    //打印修改表字段属性的存储过程,注意点:sql结尾一定要加分号,不然生成的存储过程会执行失败
    public void printModifyTableFieldSql() {
        String tableSchema = "test";
        String tableName = "t_area";
        //要修改的字段名
        String columnName = "cooo";
        String sql = "ALTER TABLE test.`t_area` MODIFY COLUMN cooo VARCHAR(25) AFTER priority;";
        System.out.println(SqlUtils.modifyTableField(tableSchema, tableName, columnName, sql));
    }

    @Test
    //打印新增表字段属性的存储过程
    public void printAddTableFieldSql() {
        String tableSchema = "test";
        String tableName = "t_area";
        //新增的字段名
        String columnName = "code";
        String sql = " ALTER TABLE test.t_area ADD COLUMN `code` VARCHAR(50) NOT NULL AFTER priority;";
        System.out.println(SqlUtils.addTableField(tableSchema, tableName, columnName, sql));
    }

    @Test
    //打印修改表字段名称的存储过程
    public void printModifyTableFieldName() {
        String tableSchema = "test";
        String tableName = "t_area";
        //要修改的字段名
        String columnName = "code";
        //新字段名
        String newName = "cooo";
        String sql = "alter table test.t_area CHANGE COLUMN `code` cooo VARCHAR(200) not null after area_id;";
        System.out.println(SqlUtils.modifyTableFieldName(tableSchema, tableName, columnName, sql, newName));
    }

    @Test
    //打印删除表字段的存储过程
    public void printDropColumn() {
        String tableSchema = "test";
        String tableName = "t_area";
        //要删除的字段名
        String columnName = "aaaabbbb";
        String sql = "alter table test.t_area drop COLUMN `aaaabbbb`;";
        System.out.println(SqlUtils.dropColumn(tableSchema, tableName, columnName, sql));
    }

    @Test
    public void test02() {
        String sql = "alter table t_area drop COLUMN  aaaabbbb;";
        System.out.println(sql.substring(sql.indexOf("COLUMN")));
        System.out.println(sql.substring(sql.indexOf("COLUMN") + 6, sql.indexOf(";")).trim());
        System.out.println(sql.substring(sql.indexOf("table") + 5, sql.indexOf("drop")).trim());
    }

}

