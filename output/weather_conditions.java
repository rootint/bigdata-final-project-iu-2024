// ORM class for table 'weather_conditions'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Wed May 08 14:46:37 MSK 2024
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

public class weather_conditions extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("location_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.location_id = (Integer)value;
      }
    });
    setters.put("temperature_celsius", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.temperature_celsius = (java.math.BigDecimal)value;
      }
    });
    setters.put("temperature_fahrenheit", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.temperature_fahrenheit = (java.math.BigDecimal)value;
      }
    });
    setters.put("condition_text", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.condition_text = (String)value;
      }
    });
    setters.put("wind_mph", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.wind_mph = (java.math.BigDecimal)value;
      }
    });
    setters.put("wind_kph", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.wind_kph = (java.math.BigDecimal)value;
      }
    });
    setters.put("wind_degree", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.wind_degree = (Integer)value;
      }
    });
    setters.put("wind_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.wind_direction = (String)value;
      }
    });
    setters.put("pressure_mb", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.pressure_mb = (java.math.BigDecimal)value;
      }
    });
    setters.put("pressure_in", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.pressure_in = (java.math.BigDecimal)value;
      }
    });
    setters.put("precip_mm", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.precip_mm = (java.math.BigDecimal)value;
      }
    });
    setters.put("precip_in", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.precip_in = (java.math.BigDecimal)value;
      }
    });
    setters.put("humidity", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.humidity = (Integer)value;
      }
    });
    setters.put("cloud", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.cloud = (Integer)value;
      }
    });
    setters.put("feels_like_celsius", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.feels_like_celsius = (java.math.BigDecimal)value;
      }
    });
    setters.put("feels_like_fahrenheit", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.feels_like_fahrenheit = (java.math.BigDecimal)value;
      }
    });
    setters.put("visibility_km", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.visibility_km = (java.math.BigDecimal)value;
      }
    });
    setters.put("visibility_miles", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.visibility_miles = (java.math.BigDecimal)value;
      }
    });
    setters.put("uv_index", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.uv_index = (java.math.BigDecimal)value;
      }
    });
    setters.put("gust_mph", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.gust_mph = (java.math.BigDecimal)value;
      }
    });
    setters.put("gust_kph", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.gust_kph = (java.math.BigDecimal)value;
      }
    });
    setters.put("sunrise", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.sunrise = (java.sql.Time)value;
      }
    });
    setters.put("sunset", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.sunset = (java.sql.Time)value;
      }
    });
    setters.put("moonrise", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.moonrise = (String)value;
      }
    });
    setters.put("moonset", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.moonset = (String)value;
      }
    });
    setters.put("moon_phase", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.moon_phase = (String)value;
      }
    });
    setters.put("moon_illumination", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        weather_conditions.this.moon_illumination = (Integer)value;
      }
    });
  }
  public weather_conditions() {
    init0();
  }
  private Integer location_id;
  public Integer get_location_id() {
    return location_id;
  }
  public void set_location_id(Integer location_id) {
    this.location_id = location_id;
  }
  public weather_conditions with_location_id(Integer location_id) {
    this.location_id = location_id;
    return this;
  }
  private java.math.BigDecimal temperature_celsius;
  public java.math.BigDecimal get_temperature_celsius() {
    return temperature_celsius;
  }
  public void set_temperature_celsius(java.math.BigDecimal temperature_celsius) {
    this.temperature_celsius = temperature_celsius;
  }
  public weather_conditions with_temperature_celsius(java.math.BigDecimal temperature_celsius) {
    this.temperature_celsius = temperature_celsius;
    return this;
  }
  private java.math.BigDecimal temperature_fahrenheit;
  public java.math.BigDecimal get_temperature_fahrenheit() {
    return temperature_fahrenheit;
  }
  public void set_temperature_fahrenheit(java.math.BigDecimal temperature_fahrenheit) {
    this.temperature_fahrenheit = temperature_fahrenheit;
  }
  public weather_conditions with_temperature_fahrenheit(java.math.BigDecimal temperature_fahrenheit) {
    this.temperature_fahrenheit = temperature_fahrenheit;
    return this;
  }
  private String condition_text;
  public String get_condition_text() {
    return condition_text;
  }
  public void set_condition_text(String condition_text) {
    this.condition_text = condition_text;
  }
  public weather_conditions with_condition_text(String condition_text) {
    this.condition_text = condition_text;
    return this;
  }
  private java.math.BigDecimal wind_mph;
  public java.math.BigDecimal get_wind_mph() {
    return wind_mph;
  }
  public void set_wind_mph(java.math.BigDecimal wind_mph) {
    this.wind_mph = wind_mph;
  }
  public weather_conditions with_wind_mph(java.math.BigDecimal wind_mph) {
    this.wind_mph = wind_mph;
    return this;
  }
  private java.math.BigDecimal wind_kph;
  public java.math.BigDecimal get_wind_kph() {
    return wind_kph;
  }
  public void set_wind_kph(java.math.BigDecimal wind_kph) {
    this.wind_kph = wind_kph;
  }
  public weather_conditions with_wind_kph(java.math.BigDecimal wind_kph) {
    this.wind_kph = wind_kph;
    return this;
  }
  private Integer wind_degree;
  public Integer get_wind_degree() {
    return wind_degree;
  }
  public void set_wind_degree(Integer wind_degree) {
    this.wind_degree = wind_degree;
  }
  public weather_conditions with_wind_degree(Integer wind_degree) {
    this.wind_degree = wind_degree;
    return this;
  }
  private String wind_direction;
  public String get_wind_direction() {
    return wind_direction;
  }
  public void set_wind_direction(String wind_direction) {
    this.wind_direction = wind_direction;
  }
  public weather_conditions with_wind_direction(String wind_direction) {
    this.wind_direction = wind_direction;
    return this;
  }
  private java.math.BigDecimal pressure_mb;
  public java.math.BigDecimal get_pressure_mb() {
    return pressure_mb;
  }
  public void set_pressure_mb(java.math.BigDecimal pressure_mb) {
    this.pressure_mb = pressure_mb;
  }
  public weather_conditions with_pressure_mb(java.math.BigDecimal pressure_mb) {
    this.pressure_mb = pressure_mb;
    return this;
  }
  private java.math.BigDecimal pressure_in;
  public java.math.BigDecimal get_pressure_in() {
    return pressure_in;
  }
  public void set_pressure_in(java.math.BigDecimal pressure_in) {
    this.pressure_in = pressure_in;
  }
  public weather_conditions with_pressure_in(java.math.BigDecimal pressure_in) {
    this.pressure_in = pressure_in;
    return this;
  }
  private java.math.BigDecimal precip_mm;
  public java.math.BigDecimal get_precip_mm() {
    return precip_mm;
  }
  public void set_precip_mm(java.math.BigDecimal precip_mm) {
    this.precip_mm = precip_mm;
  }
  public weather_conditions with_precip_mm(java.math.BigDecimal precip_mm) {
    this.precip_mm = precip_mm;
    return this;
  }
  private java.math.BigDecimal precip_in;
  public java.math.BigDecimal get_precip_in() {
    return precip_in;
  }
  public void set_precip_in(java.math.BigDecimal precip_in) {
    this.precip_in = precip_in;
  }
  public weather_conditions with_precip_in(java.math.BigDecimal precip_in) {
    this.precip_in = precip_in;
    return this;
  }
  private Integer humidity;
  public Integer get_humidity() {
    return humidity;
  }
  public void set_humidity(Integer humidity) {
    this.humidity = humidity;
  }
  public weather_conditions with_humidity(Integer humidity) {
    this.humidity = humidity;
    return this;
  }
  private Integer cloud;
  public Integer get_cloud() {
    return cloud;
  }
  public void set_cloud(Integer cloud) {
    this.cloud = cloud;
  }
  public weather_conditions with_cloud(Integer cloud) {
    this.cloud = cloud;
    return this;
  }
  private java.math.BigDecimal feels_like_celsius;
  public java.math.BigDecimal get_feels_like_celsius() {
    return feels_like_celsius;
  }
  public void set_feels_like_celsius(java.math.BigDecimal feels_like_celsius) {
    this.feels_like_celsius = feels_like_celsius;
  }
  public weather_conditions with_feels_like_celsius(java.math.BigDecimal feels_like_celsius) {
    this.feels_like_celsius = feels_like_celsius;
    return this;
  }
  private java.math.BigDecimal feels_like_fahrenheit;
  public java.math.BigDecimal get_feels_like_fahrenheit() {
    return feels_like_fahrenheit;
  }
  public void set_feels_like_fahrenheit(java.math.BigDecimal feels_like_fahrenheit) {
    this.feels_like_fahrenheit = feels_like_fahrenheit;
  }
  public weather_conditions with_feels_like_fahrenheit(java.math.BigDecimal feels_like_fahrenheit) {
    this.feels_like_fahrenheit = feels_like_fahrenheit;
    return this;
  }
  private java.math.BigDecimal visibility_km;
  public java.math.BigDecimal get_visibility_km() {
    return visibility_km;
  }
  public void set_visibility_km(java.math.BigDecimal visibility_km) {
    this.visibility_km = visibility_km;
  }
  public weather_conditions with_visibility_km(java.math.BigDecimal visibility_km) {
    this.visibility_km = visibility_km;
    return this;
  }
  private java.math.BigDecimal visibility_miles;
  public java.math.BigDecimal get_visibility_miles() {
    return visibility_miles;
  }
  public void set_visibility_miles(java.math.BigDecimal visibility_miles) {
    this.visibility_miles = visibility_miles;
  }
  public weather_conditions with_visibility_miles(java.math.BigDecimal visibility_miles) {
    this.visibility_miles = visibility_miles;
    return this;
  }
  private java.math.BigDecimal uv_index;
  public java.math.BigDecimal get_uv_index() {
    return uv_index;
  }
  public void set_uv_index(java.math.BigDecimal uv_index) {
    this.uv_index = uv_index;
  }
  public weather_conditions with_uv_index(java.math.BigDecimal uv_index) {
    this.uv_index = uv_index;
    return this;
  }
  private java.math.BigDecimal gust_mph;
  public java.math.BigDecimal get_gust_mph() {
    return gust_mph;
  }
  public void set_gust_mph(java.math.BigDecimal gust_mph) {
    this.gust_mph = gust_mph;
  }
  public weather_conditions with_gust_mph(java.math.BigDecimal gust_mph) {
    this.gust_mph = gust_mph;
    return this;
  }
  private java.math.BigDecimal gust_kph;
  public java.math.BigDecimal get_gust_kph() {
    return gust_kph;
  }
  public void set_gust_kph(java.math.BigDecimal gust_kph) {
    this.gust_kph = gust_kph;
  }
  public weather_conditions with_gust_kph(java.math.BigDecimal gust_kph) {
    this.gust_kph = gust_kph;
    return this;
  }
  private java.sql.Time sunrise;
  public java.sql.Time get_sunrise() {
    return sunrise;
  }
  public void set_sunrise(java.sql.Time sunrise) {
    this.sunrise = sunrise;
  }
  public weather_conditions with_sunrise(java.sql.Time sunrise) {
    this.sunrise = sunrise;
    return this;
  }
  private java.sql.Time sunset;
  public java.sql.Time get_sunset() {
    return sunset;
  }
  public void set_sunset(java.sql.Time sunset) {
    this.sunset = sunset;
  }
  public weather_conditions with_sunset(java.sql.Time sunset) {
    this.sunset = sunset;
    return this;
  }
  private String moonrise;
  public String get_moonrise() {
    return moonrise;
  }
  public void set_moonrise(String moonrise) {
    this.moonrise = moonrise;
  }
  public weather_conditions with_moonrise(String moonrise) {
    this.moonrise = moonrise;
    return this;
  }
  private String moonset;
  public String get_moonset() {
    return moonset;
  }
  public void set_moonset(String moonset) {
    this.moonset = moonset;
  }
  public weather_conditions with_moonset(String moonset) {
    this.moonset = moonset;
    return this;
  }
  private String moon_phase;
  public String get_moon_phase() {
    return moon_phase;
  }
  public void set_moon_phase(String moon_phase) {
    this.moon_phase = moon_phase;
  }
  public weather_conditions with_moon_phase(String moon_phase) {
    this.moon_phase = moon_phase;
    return this;
  }
  private Integer moon_illumination;
  public Integer get_moon_illumination() {
    return moon_illumination;
  }
  public void set_moon_illumination(Integer moon_illumination) {
    this.moon_illumination = moon_illumination;
  }
  public weather_conditions with_moon_illumination(Integer moon_illumination) {
    this.moon_illumination = moon_illumination;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof weather_conditions)) {
      return false;
    }
    weather_conditions that = (weather_conditions) o;
    boolean equal = true;
    equal = equal && (this.location_id == null ? that.location_id == null : this.location_id.equals(that.location_id));
    equal = equal && (this.temperature_celsius == null ? that.temperature_celsius == null : this.temperature_celsius.equals(that.temperature_celsius));
    equal = equal && (this.temperature_fahrenheit == null ? that.temperature_fahrenheit == null : this.temperature_fahrenheit.equals(that.temperature_fahrenheit));
    equal = equal && (this.condition_text == null ? that.condition_text == null : this.condition_text.equals(that.condition_text));
    equal = equal && (this.wind_mph == null ? that.wind_mph == null : this.wind_mph.equals(that.wind_mph));
    equal = equal && (this.wind_kph == null ? that.wind_kph == null : this.wind_kph.equals(that.wind_kph));
    equal = equal && (this.wind_degree == null ? that.wind_degree == null : this.wind_degree.equals(that.wind_degree));
    equal = equal && (this.wind_direction == null ? that.wind_direction == null : this.wind_direction.equals(that.wind_direction));
    equal = equal && (this.pressure_mb == null ? that.pressure_mb == null : this.pressure_mb.equals(that.pressure_mb));
    equal = equal && (this.pressure_in == null ? that.pressure_in == null : this.pressure_in.equals(that.pressure_in));
    equal = equal && (this.precip_mm == null ? that.precip_mm == null : this.precip_mm.equals(that.precip_mm));
    equal = equal && (this.precip_in == null ? that.precip_in == null : this.precip_in.equals(that.precip_in));
    equal = equal && (this.humidity == null ? that.humidity == null : this.humidity.equals(that.humidity));
    equal = equal && (this.cloud == null ? that.cloud == null : this.cloud.equals(that.cloud));
    equal = equal && (this.feels_like_celsius == null ? that.feels_like_celsius == null : this.feels_like_celsius.equals(that.feels_like_celsius));
    equal = equal && (this.feels_like_fahrenheit == null ? that.feels_like_fahrenheit == null : this.feels_like_fahrenheit.equals(that.feels_like_fahrenheit));
    equal = equal && (this.visibility_km == null ? that.visibility_km == null : this.visibility_km.equals(that.visibility_km));
    equal = equal && (this.visibility_miles == null ? that.visibility_miles == null : this.visibility_miles.equals(that.visibility_miles));
    equal = equal && (this.uv_index == null ? that.uv_index == null : this.uv_index.equals(that.uv_index));
    equal = equal && (this.gust_mph == null ? that.gust_mph == null : this.gust_mph.equals(that.gust_mph));
    equal = equal && (this.gust_kph == null ? that.gust_kph == null : this.gust_kph.equals(that.gust_kph));
    equal = equal && (this.sunrise == null ? that.sunrise == null : this.sunrise.equals(that.sunrise));
    equal = equal && (this.sunset == null ? that.sunset == null : this.sunset.equals(that.sunset));
    equal = equal && (this.moonrise == null ? that.moonrise == null : this.moonrise.equals(that.moonrise));
    equal = equal && (this.moonset == null ? that.moonset == null : this.moonset.equals(that.moonset));
    equal = equal && (this.moon_phase == null ? that.moon_phase == null : this.moon_phase.equals(that.moon_phase));
    equal = equal && (this.moon_illumination == null ? that.moon_illumination == null : this.moon_illumination.equals(that.moon_illumination));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof weather_conditions)) {
      return false;
    }
    weather_conditions that = (weather_conditions) o;
    boolean equal = true;
    equal = equal && (this.location_id == null ? that.location_id == null : this.location_id.equals(that.location_id));
    equal = equal && (this.temperature_celsius == null ? that.temperature_celsius == null : this.temperature_celsius.equals(that.temperature_celsius));
    equal = equal && (this.temperature_fahrenheit == null ? that.temperature_fahrenheit == null : this.temperature_fahrenheit.equals(that.temperature_fahrenheit));
    equal = equal && (this.condition_text == null ? that.condition_text == null : this.condition_text.equals(that.condition_text));
    equal = equal && (this.wind_mph == null ? that.wind_mph == null : this.wind_mph.equals(that.wind_mph));
    equal = equal && (this.wind_kph == null ? that.wind_kph == null : this.wind_kph.equals(that.wind_kph));
    equal = equal && (this.wind_degree == null ? that.wind_degree == null : this.wind_degree.equals(that.wind_degree));
    equal = equal && (this.wind_direction == null ? that.wind_direction == null : this.wind_direction.equals(that.wind_direction));
    equal = equal && (this.pressure_mb == null ? that.pressure_mb == null : this.pressure_mb.equals(that.pressure_mb));
    equal = equal && (this.pressure_in == null ? that.pressure_in == null : this.pressure_in.equals(that.pressure_in));
    equal = equal && (this.precip_mm == null ? that.precip_mm == null : this.precip_mm.equals(that.precip_mm));
    equal = equal && (this.precip_in == null ? that.precip_in == null : this.precip_in.equals(that.precip_in));
    equal = equal && (this.humidity == null ? that.humidity == null : this.humidity.equals(that.humidity));
    equal = equal && (this.cloud == null ? that.cloud == null : this.cloud.equals(that.cloud));
    equal = equal && (this.feels_like_celsius == null ? that.feels_like_celsius == null : this.feels_like_celsius.equals(that.feels_like_celsius));
    equal = equal && (this.feels_like_fahrenheit == null ? that.feels_like_fahrenheit == null : this.feels_like_fahrenheit.equals(that.feels_like_fahrenheit));
    equal = equal && (this.visibility_km == null ? that.visibility_km == null : this.visibility_km.equals(that.visibility_km));
    equal = equal && (this.visibility_miles == null ? that.visibility_miles == null : this.visibility_miles.equals(that.visibility_miles));
    equal = equal && (this.uv_index == null ? that.uv_index == null : this.uv_index.equals(that.uv_index));
    equal = equal && (this.gust_mph == null ? that.gust_mph == null : this.gust_mph.equals(that.gust_mph));
    equal = equal && (this.gust_kph == null ? that.gust_kph == null : this.gust_kph.equals(that.gust_kph));
    equal = equal && (this.sunrise == null ? that.sunrise == null : this.sunrise.equals(that.sunrise));
    equal = equal && (this.sunset == null ? that.sunset == null : this.sunset.equals(that.sunset));
    equal = equal && (this.moonrise == null ? that.moonrise == null : this.moonrise.equals(that.moonrise));
    equal = equal && (this.moonset == null ? that.moonset == null : this.moonset.equals(that.moonset));
    equal = equal && (this.moon_phase == null ? that.moon_phase == null : this.moon_phase.equals(that.moon_phase));
    equal = equal && (this.moon_illumination == null ? that.moon_illumination == null : this.moon_illumination.equals(that.moon_illumination));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.location_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.temperature_celsius = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.temperature_fahrenheit = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.condition_text = JdbcWritableBridge.readString(4, __dbResults);
    this.wind_mph = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.wind_kph = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.wind_degree = JdbcWritableBridge.readInteger(7, __dbResults);
    this.wind_direction = JdbcWritableBridge.readString(8, __dbResults);
    this.pressure_mb = JdbcWritableBridge.readBigDecimal(9, __dbResults);
    this.pressure_in = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.precip_mm = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.precip_in = JdbcWritableBridge.readBigDecimal(12, __dbResults);
    this.humidity = JdbcWritableBridge.readInteger(13, __dbResults);
    this.cloud = JdbcWritableBridge.readInteger(14, __dbResults);
    this.feels_like_celsius = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.feels_like_fahrenheit = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.visibility_km = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.visibility_miles = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.uv_index = JdbcWritableBridge.readBigDecimal(19, __dbResults);
    this.gust_mph = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.gust_kph = JdbcWritableBridge.readBigDecimal(21, __dbResults);
    this.sunrise = JdbcWritableBridge.readTime(22, __dbResults);
    this.sunset = JdbcWritableBridge.readTime(23, __dbResults);
    this.moonrise = JdbcWritableBridge.readString(24, __dbResults);
    this.moonset = JdbcWritableBridge.readString(25, __dbResults);
    this.moon_phase = JdbcWritableBridge.readString(26, __dbResults);
    this.moon_illumination = JdbcWritableBridge.readInteger(27, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.location_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.temperature_celsius = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.temperature_fahrenheit = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.condition_text = JdbcWritableBridge.readString(4, __dbResults);
    this.wind_mph = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.wind_kph = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.wind_degree = JdbcWritableBridge.readInteger(7, __dbResults);
    this.wind_direction = JdbcWritableBridge.readString(8, __dbResults);
    this.pressure_mb = JdbcWritableBridge.readBigDecimal(9, __dbResults);
    this.pressure_in = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.precip_mm = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.precip_in = JdbcWritableBridge.readBigDecimal(12, __dbResults);
    this.humidity = JdbcWritableBridge.readInteger(13, __dbResults);
    this.cloud = JdbcWritableBridge.readInteger(14, __dbResults);
    this.feels_like_celsius = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.feels_like_fahrenheit = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.visibility_km = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.visibility_miles = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.uv_index = JdbcWritableBridge.readBigDecimal(19, __dbResults);
    this.gust_mph = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.gust_kph = JdbcWritableBridge.readBigDecimal(21, __dbResults);
    this.sunrise = JdbcWritableBridge.readTime(22, __dbResults);
    this.sunset = JdbcWritableBridge.readTime(23, __dbResults);
    this.moonrise = JdbcWritableBridge.readString(24, __dbResults);
    this.moonset = JdbcWritableBridge.readString(25, __dbResults);
    this.moon_phase = JdbcWritableBridge.readString(26, __dbResults);
    this.moon_illumination = JdbcWritableBridge.readInteger(27, __dbResults);
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
    JdbcWritableBridge.writeBigDecimal(temperature_celsius, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(temperature_fahrenheit, 3 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(condition_text, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_mph, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_kph, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(wind_degree, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(wind_direction, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pressure_mb, 9 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pressure_in, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(precip_mm, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(precip_in, 12 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(humidity, 13 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(cloud, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(feels_like_celsius, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(feels_like_fahrenheit, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(visibility_km, 17 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(visibility_miles, 18 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(uv_index, 19 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(gust_mph, 20 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(gust_kph, 21 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeTime(sunrise, 22 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeTime(sunset, 23 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeString(moonrise, 24 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(moonset, 25 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(moon_phase, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(moon_illumination, 27 + __off, 4, __dbStmt);
    return 27;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(location_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(temperature_celsius, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(temperature_fahrenheit, 3 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(condition_text, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_mph, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_kph, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(wind_degree, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(wind_direction, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pressure_mb, 9 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pressure_in, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(precip_mm, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(precip_in, 12 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(humidity, 13 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(cloud, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(feels_like_celsius, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(feels_like_fahrenheit, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(visibility_km, 17 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(visibility_miles, 18 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(uv_index, 19 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(gust_mph, 20 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(gust_kph, 21 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeTime(sunrise, 22 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeTime(sunset, 23 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeString(moonrise, 24 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(moonset, 25 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(moon_phase, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(moon_illumination, 27 + __off, 4, __dbStmt);
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
        this.temperature_celsius = null;
    } else {
    this.temperature_celsius = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.temperature_fahrenheit = null;
    } else {
    this.temperature_fahrenheit = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.condition_text = null;
    } else {
    this.condition_text = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wind_mph = null;
    } else {
    this.wind_mph = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wind_kph = null;
    } else {
    this.wind_kph = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wind_degree = null;
    } else {
    this.wind_degree = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.wind_direction = null;
    } else {
    this.wind_direction = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pressure_mb = null;
    } else {
    this.pressure_mb = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pressure_in = null;
    } else {
    this.pressure_in = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.precip_mm = null;
    } else {
    this.precip_mm = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.precip_in = null;
    } else {
    this.precip_in = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.humidity = null;
    } else {
    this.humidity = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.cloud = null;
    } else {
    this.cloud = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.feels_like_celsius = null;
    } else {
    this.feels_like_celsius = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.feels_like_fahrenheit = null;
    } else {
    this.feels_like_fahrenheit = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.visibility_km = null;
    } else {
    this.visibility_km = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.visibility_miles = null;
    } else {
    this.visibility_miles = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.uv_index = null;
    } else {
    this.uv_index = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.gust_mph = null;
    } else {
    this.gust_mph = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.gust_kph = null;
    } else {
    this.gust_kph = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.sunrise = null;
    } else {
    this.sunrise = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.sunset = null;
    } else {
    this.sunset = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.moonrise = null;
    } else {
    this.moonrise = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.moonset = null;
    } else {
    this.moonset = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.moon_phase = null;
    } else {
    this.moon_phase = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.moon_illumination = null;
    } else {
    this.moon_illumination = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.location_id);
    }
    if (null == this.temperature_celsius) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.temperature_celsius, __dataOut);
    }
    if (null == this.temperature_fahrenheit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.temperature_fahrenheit, __dataOut);
    }
    if (null == this.condition_text) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, condition_text);
    }
    if (null == this.wind_mph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.wind_mph, __dataOut);
    }
    if (null == this.wind_kph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.wind_kph, __dataOut);
    }
    if (null == this.wind_degree) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.wind_degree);
    }
    if (null == this.wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wind_direction);
    }
    if (null == this.pressure_mb) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pressure_mb, __dataOut);
    }
    if (null == this.pressure_in) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pressure_in, __dataOut);
    }
    if (null == this.precip_mm) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.precip_mm, __dataOut);
    }
    if (null == this.precip_in) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.precip_in, __dataOut);
    }
    if (null == this.humidity) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.humidity);
    }
    if (null == this.cloud) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.cloud);
    }
    if (null == this.feels_like_celsius) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.feels_like_celsius, __dataOut);
    }
    if (null == this.feels_like_fahrenheit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.feels_like_fahrenheit, __dataOut);
    }
    if (null == this.visibility_km) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.visibility_km, __dataOut);
    }
    if (null == this.visibility_miles) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.visibility_miles, __dataOut);
    }
    if (null == this.uv_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.uv_index, __dataOut);
    }
    if (null == this.gust_mph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.gust_mph, __dataOut);
    }
    if (null == this.gust_kph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.gust_kph, __dataOut);
    }
    if (null == this.sunrise) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.sunrise.getTime());
    }
    if (null == this.sunset) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.sunset.getTime());
    }
    if (null == this.moonrise) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, moonrise);
    }
    if (null == this.moonset) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, moonset);
    }
    if (null == this.moon_phase) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, moon_phase);
    }
    if (null == this.moon_illumination) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.moon_illumination);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.location_id);
    }
    if (null == this.temperature_celsius) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.temperature_celsius, __dataOut);
    }
    if (null == this.temperature_fahrenheit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.temperature_fahrenheit, __dataOut);
    }
    if (null == this.condition_text) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, condition_text);
    }
    if (null == this.wind_mph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.wind_mph, __dataOut);
    }
    if (null == this.wind_kph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.wind_kph, __dataOut);
    }
    if (null == this.wind_degree) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.wind_degree);
    }
    if (null == this.wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wind_direction);
    }
    if (null == this.pressure_mb) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pressure_mb, __dataOut);
    }
    if (null == this.pressure_in) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pressure_in, __dataOut);
    }
    if (null == this.precip_mm) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.precip_mm, __dataOut);
    }
    if (null == this.precip_in) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.precip_in, __dataOut);
    }
    if (null == this.humidity) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.humidity);
    }
    if (null == this.cloud) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.cloud);
    }
    if (null == this.feels_like_celsius) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.feels_like_celsius, __dataOut);
    }
    if (null == this.feels_like_fahrenheit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.feels_like_fahrenheit, __dataOut);
    }
    if (null == this.visibility_km) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.visibility_km, __dataOut);
    }
    if (null == this.visibility_miles) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.visibility_miles, __dataOut);
    }
    if (null == this.uv_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.uv_index, __dataOut);
    }
    if (null == this.gust_mph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.gust_mph, __dataOut);
    }
    if (null == this.gust_kph) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.gust_kph, __dataOut);
    }
    if (null == this.sunrise) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.sunrise.getTime());
    }
    if (null == this.sunset) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.sunset.getTime());
    }
    if (null == this.moonrise) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, moonrise);
    }
    if (null == this.moonset) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, moonset);
    }
    if (null == this.moon_phase) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, moon_phase);
    }
    if (null == this.moon_illumination) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.moon_illumination);
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
    __sb.append(FieldFormatter.escapeAndEnclose(temperature_celsius==null?"null":temperature_celsius.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(temperature_fahrenheit==null?"null":temperature_fahrenheit.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(condition_text==null?"null":condition_text, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_mph==null?"null":wind_mph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_kph==null?"null":wind_kph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_degree==null?"null":"" + wind_degree, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_direction==null?"null":wind_direction, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure_mb==null?"null":pressure_mb.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure_in==null?"null":pressure_in.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(precip_mm==null?"null":precip_mm.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(precip_in==null?"null":precip_in.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(humidity==null?"null":"" + humidity, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cloud==null?"null":"" + cloud, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(feels_like_celsius==null?"null":feels_like_celsius.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(feels_like_fahrenheit==null?"null":feels_like_fahrenheit.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(visibility_km==null?"null":visibility_km.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(visibility_miles==null?"null":visibility_miles.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(uv_index==null?"null":uv_index.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gust_mph==null?"null":gust_mph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gust_kph==null?"null":gust_kph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sunrise==null?"null":"" + sunrise, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sunset==null?"null":"" + sunset, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moonrise==null?"null":moonrise, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moonset==null?"null":moonset, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moon_phase==null?"null":moon_phase, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moon_illumination==null?"null":"" + moon_illumination, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(location_id==null?"null":"" + location_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(temperature_celsius==null?"null":temperature_celsius.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(temperature_fahrenheit==null?"null":temperature_fahrenheit.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(condition_text==null?"null":condition_text, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_mph==null?"null":wind_mph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_kph==null?"null":wind_kph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_degree==null?"null":"" + wind_degree, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_direction==null?"null":wind_direction, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure_mb==null?"null":pressure_mb.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure_in==null?"null":pressure_in.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(precip_mm==null?"null":precip_mm.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(precip_in==null?"null":precip_in.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(humidity==null?"null":"" + humidity, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cloud==null?"null":"" + cloud, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(feels_like_celsius==null?"null":feels_like_celsius.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(feels_like_fahrenheit==null?"null":feels_like_fahrenheit.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(visibility_km==null?"null":visibility_km.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(visibility_miles==null?"null":visibility_miles.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(uv_index==null?"null":uv_index.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gust_mph==null?"null":gust_mph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gust_kph==null?"null":gust_kph.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sunrise==null?"null":"" + sunrise, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sunset==null?"null":"" + sunset, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moonrise==null?"null":moonrise, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moonset==null?"null":moonset, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moon_phase==null?"null":moon_phase, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(moon_illumination==null?"null":"" + moon_illumination, delimiters));
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.temperature_celsius = null; } else {
      this.temperature_celsius = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.temperature_fahrenheit = null; } else {
      this.temperature_fahrenheit = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.condition_text = null; } else {
      this.condition_text = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_mph = null; } else {
      this.wind_mph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_kph = null; } else {
      this.wind_kph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_degree = null; } else {
      this.wind_degree = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.wind_direction = null; } else {
      this.wind_direction = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pressure_mb = null; } else {
      this.pressure_mb = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pressure_in = null; } else {
      this.pressure_in = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.precip_mm = null; } else {
      this.precip_mm = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.precip_in = null; } else {
      this.precip_in = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.humidity = null; } else {
      this.humidity = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cloud = null; } else {
      this.cloud = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.feels_like_celsius = null; } else {
      this.feels_like_celsius = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.feels_like_fahrenheit = null; } else {
      this.feels_like_fahrenheit = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.visibility_km = null; } else {
      this.visibility_km = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.visibility_miles = null; } else {
      this.visibility_miles = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.uv_index = null; } else {
      this.uv_index = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gust_mph = null; } else {
      this.gust_mph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gust_kph = null; } else {
      this.gust_kph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sunrise = null; } else {
      this.sunrise = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sunset = null; } else {
      this.sunset = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.moonrise = null; } else {
      this.moonrise = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.moonset = null; } else {
      this.moonset = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.moon_phase = null; } else {
      this.moon_phase = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.moon_illumination = null; } else {
      this.moon_illumination = Integer.valueOf(__cur_str);
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.temperature_celsius = null; } else {
      this.temperature_celsius = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.temperature_fahrenheit = null; } else {
      this.temperature_fahrenheit = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.condition_text = null; } else {
      this.condition_text = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_mph = null; } else {
      this.wind_mph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_kph = null; } else {
      this.wind_kph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_degree = null; } else {
      this.wind_degree = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.wind_direction = null; } else {
      this.wind_direction = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pressure_mb = null; } else {
      this.pressure_mb = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pressure_in = null; } else {
      this.pressure_in = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.precip_mm = null; } else {
      this.precip_mm = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.precip_in = null; } else {
      this.precip_in = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.humidity = null; } else {
      this.humidity = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cloud = null; } else {
      this.cloud = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.feels_like_celsius = null; } else {
      this.feels_like_celsius = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.feels_like_fahrenheit = null; } else {
      this.feels_like_fahrenheit = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.visibility_km = null; } else {
      this.visibility_km = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.visibility_miles = null; } else {
      this.visibility_miles = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.uv_index = null; } else {
      this.uv_index = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gust_mph = null; } else {
      this.gust_mph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gust_kph = null; } else {
      this.gust_kph = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sunrise = null; } else {
      this.sunrise = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sunset = null; } else {
      this.sunset = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.moonrise = null; } else {
      this.moonrise = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.moonset = null; } else {
      this.moonset = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.moon_phase = null; } else {
      this.moon_phase = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.moon_illumination = null; } else {
      this.moon_illumination = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    weather_conditions o = (weather_conditions) super.clone();
    o.sunrise = (o.sunrise != null) ? (java.sql.Time) o.sunrise.clone() : null;
    o.sunset = (o.sunset != null) ? (java.sql.Time) o.sunset.clone() : null;
    return o;
  }

  public void clone0(weather_conditions o) throws CloneNotSupportedException {
    o.sunrise = (o.sunrise != null) ? (java.sql.Time) o.sunrise.clone() : null;
    o.sunset = (o.sunset != null) ? (java.sql.Time) o.sunset.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("location_id", this.location_id);
    __sqoop$field_map.put("temperature_celsius", this.temperature_celsius);
    __sqoop$field_map.put("temperature_fahrenheit", this.temperature_fahrenheit);
    __sqoop$field_map.put("condition_text", this.condition_text);
    __sqoop$field_map.put("wind_mph", this.wind_mph);
    __sqoop$field_map.put("wind_kph", this.wind_kph);
    __sqoop$field_map.put("wind_degree", this.wind_degree);
    __sqoop$field_map.put("wind_direction", this.wind_direction);
    __sqoop$field_map.put("pressure_mb", this.pressure_mb);
    __sqoop$field_map.put("pressure_in", this.pressure_in);
    __sqoop$field_map.put("precip_mm", this.precip_mm);
    __sqoop$field_map.put("precip_in", this.precip_in);
    __sqoop$field_map.put("humidity", this.humidity);
    __sqoop$field_map.put("cloud", this.cloud);
    __sqoop$field_map.put("feels_like_celsius", this.feels_like_celsius);
    __sqoop$field_map.put("feels_like_fahrenheit", this.feels_like_fahrenheit);
    __sqoop$field_map.put("visibility_km", this.visibility_km);
    __sqoop$field_map.put("visibility_miles", this.visibility_miles);
    __sqoop$field_map.put("uv_index", this.uv_index);
    __sqoop$field_map.put("gust_mph", this.gust_mph);
    __sqoop$field_map.put("gust_kph", this.gust_kph);
    __sqoop$field_map.put("sunrise", this.sunrise);
    __sqoop$field_map.put("sunset", this.sunset);
    __sqoop$field_map.put("moonrise", this.moonrise);
    __sqoop$field_map.put("moonset", this.moonset);
    __sqoop$field_map.put("moon_phase", this.moon_phase);
    __sqoop$field_map.put("moon_illumination", this.moon_illumination);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("location_id", this.location_id);
    __sqoop$field_map.put("temperature_celsius", this.temperature_celsius);
    __sqoop$field_map.put("temperature_fahrenheit", this.temperature_fahrenheit);
    __sqoop$field_map.put("condition_text", this.condition_text);
    __sqoop$field_map.put("wind_mph", this.wind_mph);
    __sqoop$field_map.put("wind_kph", this.wind_kph);
    __sqoop$field_map.put("wind_degree", this.wind_degree);
    __sqoop$field_map.put("wind_direction", this.wind_direction);
    __sqoop$field_map.put("pressure_mb", this.pressure_mb);
    __sqoop$field_map.put("pressure_in", this.pressure_in);
    __sqoop$field_map.put("precip_mm", this.precip_mm);
    __sqoop$field_map.put("precip_in", this.precip_in);
    __sqoop$field_map.put("humidity", this.humidity);
    __sqoop$field_map.put("cloud", this.cloud);
    __sqoop$field_map.put("feels_like_celsius", this.feels_like_celsius);
    __sqoop$field_map.put("feels_like_fahrenheit", this.feels_like_fahrenheit);
    __sqoop$field_map.put("visibility_km", this.visibility_km);
    __sqoop$field_map.put("visibility_miles", this.visibility_miles);
    __sqoop$field_map.put("uv_index", this.uv_index);
    __sqoop$field_map.put("gust_mph", this.gust_mph);
    __sqoop$field_map.put("gust_kph", this.gust_kph);
    __sqoop$field_map.put("sunrise", this.sunrise);
    __sqoop$field_map.put("sunset", this.sunset);
    __sqoop$field_map.put("moonrise", this.moonrise);
    __sqoop$field_map.put("moonset", this.moonset);
    __sqoop$field_map.put("moon_phase", this.moon_phase);
    __sqoop$field_map.put("moon_illumination", this.moon_illumination);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
