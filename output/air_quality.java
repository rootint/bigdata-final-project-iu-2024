// ORM class for table 'air_quality'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Wed May 08 14:46:20 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class air_quality extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("location_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.location_id = (Integer)value;
      }
    });
    setters.put("air_quality_carbon_monoxide", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_carbon_monoxide = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_quality_ozone", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_ozone = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_quality_nitrogen_dioxide", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_nitrogen_dioxide = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_quality_sulphur_dioxide", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_sulphur_dioxide = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_quality_pm2_5", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_pm2_5 = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_quality_pm10", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_pm10 = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_quality_us_epa_index", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_us_epa_index = (Integer)value;
      }
    });
    setters.put("air_quality_gb_defra_index", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_quality.this.air_quality_gb_defra_index = (Integer)value;
      }
    });
  }
  public air_quality() {
    init0();
  }
  private Integer location_id;
  public Integer get_location_id() {
    return location_id;
  }
  public void set_location_id(Integer location_id) {
    this.location_id = location_id;
  }
  public air_quality with_location_id(Integer location_id) {
    this.location_id = location_id;
    return this;
  }
  private java.math.BigDecimal air_quality_carbon_monoxide;
  public java.math.BigDecimal get_air_quality_carbon_monoxide() {
    return air_quality_carbon_monoxide;
  }
  public void set_air_quality_carbon_monoxide(java.math.BigDecimal air_quality_carbon_monoxide) {
    this.air_quality_carbon_monoxide = air_quality_carbon_monoxide;
  }
  public air_quality with_air_quality_carbon_monoxide(java.math.BigDecimal air_quality_carbon_monoxide) {
    this.air_quality_carbon_monoxide = air_quality_carbon_monoxide;
    return this;
  }
  private java.math.BigDecimal air_quality_ozone;
  public java.math.BigDecimal get_air_quality_ozone() {
    return air_quality_ozone;
  }
  public void set_air_quality_ozone(java.math.BigDecimal air_quality_ozone) {
    this.air_quality_ozone = air_quality_ozone;
  }
  public air_quality with_air_quality_ozone(java.math.BigDecimal air_quality_ozone) {
    this.air_quality_ozone = air_quality_ozone;
    return this;
  }
  private java.math.BigDecimal air_quality_nitrogen_dioxide;
  public java.math.BigDecimal get_air_quality_nitrogen_dioxide() {
    return air_quality_nitrogen_dioxide;
  }
  public void set_air_quality_nitrogen_dioxide(java.math.BigDecimal air_quality_nitrogen_dioxide) {
    this.air_quality_nitrogen_dioxide = air_quality_nitrogen_dioxide;
  }
  public air_quality with_air_quality_nitrogen_dioxide(java.math.BigDecimal air_quality_nitrogen_dioxide) {
    this.air_quality_nitrogen_dioxide = air_quality_nitrogen_dioxide;
    return this;
  }
  private java.math.BigDecimal air_quality_sulphur_dioxide;
  public java.math.BigDecimal get_air_quality_sulphur_dioxide() {
    return air_quality_sulphur_dioxide;
  }
  public void set_air_quality_sulphur_dioxide(java.math.BigDecimal air_quality_sulphur_dioxide) {
    this.air_quality_sulphur_dioxide = air_quality_sulphur_dioxide;
  }
  public air_quality with_air_quality_sulphur_dioxide(java.math.BigDecimal air_quality_sulphur_dioxide) {
    this.air_quality_sulphur_dioxide = air_quality_sulphur_dioxide;
    return this;
  }
  private java.math.BigDecimal air_quality_pm2_5;
  public java.math.BigDecimal get_air_quality_pm2_5() {
    return air_quality_pm2_5;
  }
  public void set_air_quality_pm2_5(java.math.BigDecimal air_quality_pm2_5) {
    this.air_quality_pm2_5 = air_quality_pm2_5;
  }
  public air_quality with_air_quality_pm2_5(java.math.BigDecimal air_quality_pm2_5) {
    this.air_quality_pm2_5 = air_quality_pm2_5;
    return this;
  }
  private java.math.BigDecimal air_quality_pm10;
  public java.math.BigDecimal get_air_quality_pm10() {
    return air_quality_pm10;
  }
  public void set_air_quality_pm10(java.math.BigDecimal air_quality_pm10) {
    this.air_quality_pm10 = air_quality_pm10;
  }
  public air_quality with_air_quality_pm10(java.math.BigDecimal air_quality_pm10) {
    this.air_quality_pm10 = air_quality_pm10;
    return this;
  }
  private Integer air_quality_us_epa_index;
  public Integer get_air_quality_us_epa_index() {
    return air_quality_us_epa_index;
  }
  public void set_air_quality_us_epa_index(Integer air_quality_us_epa_index) {
    this.air_quality_us_epa_index = air_quality_us_epa_index;
  }
  public air_quality with_air_quality_us_epa_index(Integer air_quality_us_epa_index) {
    this.air_quality_us_epa_index = air_quality_us_epa_index;
    return this;
  }
  private Integer air_quality_gb_defra_index;
  public Integer get_air_quality_gb_defra_index() {
    return air_quality_gb_defra_index;
  }
  public void set_air_quality_gb_defra_index(Integer air_quality_gb_defra_index) {
    this.air_quality_gb_defra_index = air_quality_gb_defra_index;
  }
  public air_quality with_air_quality_gb_defra_index(Integer air_quality_gb_defra_index) {
    this.air_quality_gb_defra_index = air_quality_gb_defra_index;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof air_quality)) {
      return false;
    }
    air_quality that = (air_quality) o;
    boolean equal = true;
    equal = equal && (this.location_id == null ? that.location_id == null : this.location_id.equals(that.location_id));
    equal = equal && (this.air_quality_carbon_monoxide == null ? that.air_quality_carbon_monoxide == null : this.air_quality_carbon_monoxide.equals(that.air_quality_carbon_monoxide));
    equal = equal && (this.air_quality_ozone == null ? that.air_quality_ozone == null : this.air_quality_ozone.equals(that.air_quality_ozone));
    equal = equal && (this.air_quality_nitrogen_dioxide == null ? that.air_quality_nitrogen_dioxide == null : this.air_quality_nitrogen_dioxide.equals(that.air_quality_nitrogen_dioxide));
    equal = equal && (this.air_quality_sulphur_dioxide == null ? that.air_quality_sulphur_dioxide == null : this.air_quality_sulphur_dioxide.equals(that.air_quality_sulphur_dioxide));
    equal = equal && (this.air_quality_pm2_5 == null ? that.air_quality_pm2_5 == null : this.air_quality_pm2_5.equals(that.air_quality_pm2_5));
    equal = equal && (this.air_quality_pm10 == null ? that.air_quality_pm10 == null : this.air_quality_pm10.equals(that.air_quality_pm10));
    equal = equal && (this.air_quality_us_epa_index == null ? that.air_quality_us_epa_index == null : this.air_quality_us_epa_index.equals(that.air_quality_us_epa_index));
    equal = equal && (this.air_quality_gb_defra_index == null ? that.air_quality_gb_defra_index == null : this.air_quality_gb_defra_index.equals(that.air_quality_gb_defra_index));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof air_quality)) {
      return false;
    }
    air_quality that = (air_quality) o;
    boolean equal = true;
    equal = equal && (this.location_id == null ? that.location_id == null : this.location_id.equals(that.location_id));
    equal = equal && (this.air_quality_carbon_monoxide == null ? that.air_quality_carbon_monoxide == null : this.air_quality_carbon_monoxide.equals(that.air_quality_carbon_monoxide));
    equal = equal && (this.air_quality_ozone == null ? that.air_quality_ozone == null : this.air_quality_ozone.equals(that.air_quality_ozone));
    equal = equal && (this.air_quality_nitrogen_dioxide == null ? that.air_quality_nitrogen_dioxide == null : this.air_quality_nitrogen_dioxide.equals(that.air_quality_nitrogen_dioxide));
    equal = equal && (this.air_quality_sulphur_dioxide == null ? that.air_quality_sulphur_dioxide == null : this.air_quality_sulphur_dioxide.equals(that.air_quality_sulphur_dioxide));
    equal = equal && (this.air_quality_pm2_5 == null ? that.air_quality_pm2_5 == null : this.air_quality_pm2_5.equals(that.air_quality_pm2_5));
    equal = equal && (this.air_quality_pm10 == null ? that.air_quality_pm10 == null : this.air_quality_pm10.equals(that.air_quality_pm10));
    equal = equal && (this.air_quality_us_epa_index == null ? that.air_quality_us_epa_index == null : this.air_quality_us_epa_index.equals(that.air_quality_us_epa_index));
    equal = equal && (this.air_quality_gb_defra_index == null ? that.air_quality_gb_defra_index == null : this.air_quality_gb_defra_index.equals(that.air_quality_gb_defra_index));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.location_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.air_quality_carbon_monoxide = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.air_quality_ozone = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.air_quality_nitrogen_dioxide = JdbcWritableBridge.readBigDecimal(4, __dbResults);
    this.air_quality_sulphur_dioxide = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.air_quality_pm2_5 = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.air_quality_pm10 = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.air_quality_us_epa_index = JdbcWritableBridge.readInteger(8, __dbResults);
    this.air_quality_gb_defra_index = JdbcWritableBridge.readInteger(9, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.location_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.air_quality_carbon_monoxide = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.air_quality_ozone = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.air_quality_nitrogen_dioxide = JdbcWritableBridge.readBigDecimal(4, __dbResults);
    this.air_quality_sulphur_dioxide = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.air_quality_pm2_5 = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.air_quality_pm10 = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.air_quality_us_epa_index = JdbcWritableBridge.readInteger(8, __dbResults);
    this.air_quality_gb_defra_index = JdbcWritableBridge.readInteger(9, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(location_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_carbon_monoxide, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_ozone, 3 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_nitrogen_dioxide, 4 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_sulphur_dioxide, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_pm2_5, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_pm10, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(air_quality_us_epa_index, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(air_quality_gb_defra_index, 9 + __off, 4, __dbStmt);
    return 9;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(location_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_carbon_monoxide, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_ozone, 3 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_nitrogen_dioxide, 4 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_sulphur_dioxide, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_pm2_5, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_quality_pm10, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(air_quality_us_epa_index, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(air_quality_gb_defra_index, 9 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.location_id = null;
    } else {
    this.location_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_carbon_monoxide = null;
    } else {
    this.air_quality_carbon_monoxide = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_ozone = null;
    } else {
    this.air_quality_ozone = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_nitrogen_dioxide = null;
    } else {
    this.air_quality_nitrogen_dioxide = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_sulphur_dioxide = null;
    } else {
    this.air_quality_sulphur_dioxide = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_pm2_5 = null;
    } else {
    this.air_quality_pm2_5 = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_pm10 = null;
    } else {
    this.air_quality_pm10 = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_us_epa_index = null;
    } else {
    this.air_quality_us_epa_index = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.air_quality_gb_defra_index = null;
    } else {
    this.air_quality_gb_defra_index = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.location_id);
    }
    if (null == this.air_quality_carbon_monoxide) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_carbon_monoxide, __dataOut);
    }
    if (null == this.air_quality_ozone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_ozone, __dataOut);
    }
    if (null == this.air_quality_nitrogen_dioxide) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_nitrogen_dioxide, __dataOut);
    }
    if (null == this.air_quality_sulphur_dioxide) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_sulphur_dioxide, __dataOut);
    }
    if (null == this.air_quality_pm2_5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_pm2_5, __dataOut);
    }
    if (null == this.air_quality_pm10) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_pm10, __dataOut);
    }
    if (null == this.air_quality_us_epa_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.air_quality_us_epa_index);
    }
    if (null == this.air_quality_gb_defra_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.air_quality_gb_defra_index);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.location_id);
    }
    if (null == this.air_quality_carbon_monoxide) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_carbon_monoxide, __dataOut);
    }
    if (null == this.air_quality_ozone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_ozone, __dataOut);
    }
    if (null == this.air_quality_nitrogen_dioxide) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_nitrogen_dioxide, __dataOut);
    }
    if (null == this.air_quality_sulphur_dioxide) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_sulphur_dioxide, __dataOut);
    }
    if (null == this.air_quality_pm2_5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_pm2_5, __dataOut);
    }
    if (null == this.air_quality_pm10) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.air_quality_pm10, __dataOut);
    }
    if (null == this.air_quality_us_epa_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.air_quality_us_epa_index);
    }
    if (null == this.air_quality_gb_defra_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.air_quality_gb_defra_index);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(location_id==null?"null":"" + location_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_carbon_monoxide==null?"null":air_quality_carbon_monoxide.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_ozone==null?"null":air_quality_ozone.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_nitrogen_dioxide==null?"null":air_quality_nitrogen_dioxide.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_sulphur_dioxide==null?"null":air_quality_sulphur_dioxide.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_pm2_5==null?"null":air_quality_pm2_5.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_pm10==null?"null":air_quality_pm10.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_us_epa_index==null?"null":"" + air_quality_us_epa_index, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_gb_defra_index==null?"null":"" + air_quality_gb_defra_index, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(location_id==null?"null":"" + location_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_carbon_monoxide==null?"null":air_quality_carbon_monoxide.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_ozone==null?"null":air_quality_ozone.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_nitrogen_dioxide==null?"null":air_quality_nitrogen_dioxide.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_sulphur_dioxide==null?"null":air_quality_sulphur_dioxide.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_pm2_5==null?"null":air_quality_pm2_5.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_pm10==null?"null":air_quality_pm10.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_us_epa_index==null?"null":"" + air_quality_us_epa_index, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_quality_gb_defra_index==null?"null":"" + air_quality_gb_defra_index, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.location_id = null; } else {
      this.location_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_carbon_monoxide = null; } else {
      this.air_quality_carbon_monoxide = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_ozone = null; } else {
      this.air_quality_ozone = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_nitrogen_dioxide = null; } else {
      this.air_quality_nitrogen_dioxide = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_sulphur_dioxide = null; } else {
      this.air_quality_sulphur_dioxide = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_pm2_5 = null; } else {
      this.air_quality_pm2_5 = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_pm10 = null; } else {
      this.air_quality_pm10 = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_us_epa_index = null; } else {
      this.air_quality_us_epa_index = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_gb_defra_index = null; } else {
      this.air_quality_gb_defra_index = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.location_id = null; } else {
      this.location_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_carbon_monoxide = null; } else {
      this.air_quality_carbon_monoxide = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_ozone = null; } else {
      this.air_quality_ozone = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_nitrogen_dioxide = null; } else {
      this.air_quality_nitrogen_dioxide = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_sulphur_dioxide = null; } else {
      this.air_quality_sulphur_dioxide = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_pm2_5 = null; } else {
      this.air_quality_pm2_5 = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_pm10 = null; } else {
      this.air_quality_pm10 = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_us_epa_index = null; } else {
      this.air_quality_us_epa_index = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_quality_gb_defra_index = null; } else {
      this.air_quality_gb_defra_index = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    air_quality o = (air_quality) super.clone();
    return o;
  }

  public void clone0(air_quality o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("location_id", this.location_id);
    __sqoop$field_map.put("air_quality_carbon_monoxide", this.air_quality_carbon_monoxide);
    __sqoop$field_map.put("air_quality_ozone", this.air_quality_ozone);
    __sqoop$field_map.put("air_quality_nitrogen_dioxide", this.air_quality_nitrogen_dioxide);
    __sqoop$field_map.put("air_quality_sulphur_dioxide", this.air_quality_sulphur_dioxide);
    __sqoop$field_map.put("air_quality_pm2_5", this.air_quality_pm2_5);
    __sqoop$field_map.put("air_quality_pm10", this.air_quality_pm10);
    __sqoop$field_map.put("air_quality_us_epa_index", this.air_quality_us_epa_index);
    __sqoop$field_map.put("air_quality_gb_defra_index", this.air_quality_gb_defra_index);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("location_id", this.location_id);
    __sqoop$field_map.put("air_quality_carbon_monoxide", this.air_quality_carbon_monoxide);
    __sqoop$field_map.put("air_quality_ozone", this.air_quality_ozone);
    __sqoop$field_map.put("air_quality_nitrogen_dioxide", this.air_quality_nitrogen_dioxide);
    __sqoop$field_map.put("air_quality_sulphur_dioxide", this.air_quality_sulphur_dioxide);
    __sqoop$field_map.put("air_quality_pm2_5", this.air_quality_pm2_5);
    __sqoop$field_map.put("air_quality_pm10", this.air_quality_pm10);
    __sqoop$field_map.put("air_quality_us_epa_index", this.air_quality_us_epa_index);
    __sqoop$field_map.put("air_quality_gb_defra_index", this.air_quality_gb_defra_index);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
