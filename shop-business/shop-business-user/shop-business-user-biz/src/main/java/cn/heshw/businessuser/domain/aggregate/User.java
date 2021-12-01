package cn.heshw.businessuser.domain.aggregate;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.DefaultEntity;
import java.util.Date;

public class User extends DefaultEntity implements AggregateRoot {

  private final String name;
  private final String[] roles;
  private final Date registerTime;

  public User(UserBuilder builder) {
    super(builder);
    this.name = builder.name;
    this.roles = builder.roles;
    this.registerTime = builder.registerTime;
  }

  public static class UserBuilder extends Builder<UserBuilder> {
    private String name;
    private String[] roles;
    private Date registerTime;

    public UserBuilder name(String val) {
      this.name = val;
      return this;
    }

    public UserBuilder roles(String val) {
      if (isNotBlank(val)) {
        this.roles = val.split(",");
      }
      return this;
    }

    public UserBuilder registerTime(Date val) {
      this.registerTime = val;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }
}