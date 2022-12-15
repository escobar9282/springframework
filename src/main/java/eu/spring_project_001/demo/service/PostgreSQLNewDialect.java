package eu.spring_project_001.demo.service;

import org.hibernate.dialect.PostgreSQL10Dialect;

import java.sql.Types;

public class PostgreSQLNewDialect extends PostgreSQL10Dialect
{
  /*  public PostgreSQLNewDialect()
    {
        super();
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.TINYINT, "smallint");
        registerColumnType(Types.BOOLEAN, "boolean");
    }*/
}
