package cn.heshw.businessuser.domain.aggregate;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.DefaultEntity;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Account extends DefaultEntity implements AggregateRoot {

  private final String name;
  private final List<String> roles;
  private final String password;
  private final Date registerTime;

  public Account(AccountBuilder builder) {
    super(builder);
    this.name = builder.name;
    this.roles = builder.roles;
    this.registerTime = builder.registerTime;
    this.password = builder.password;
  }

  public static AccountBuilder builder() {
    return new AccountBuilder();
  }

  public static class AccountBuilder extends Builder<AccountBuilder> {
    private String name;
    private List<String> roles;
    private String password;
    private Date registerTime;

    public AccountBuilder name(String val) {
      this.name = val;
      return this;
    }

    public AccountBuilder roles(String val) {
      if (isNotBlank(val)) {
        this.roles = Arrays.asList(val.split(","));
      }
      return this;
    }

    public AccountBuilder password(String val) {
      this.password = val;
      return this;
    }

    public AccountBuilder registerTime(Date val) {
      this.registerTime = val;
      return this;
    }

    public Account build() {
      return new Account(this);
    }
  }

  public String getName() {
    return name;
  }

  public List<String> getRoles() {
    return roles;
  }

  public String getPassword() {
    return password;
  }

  public Date getRegisterTime() {
    return registerTime;
  }
}