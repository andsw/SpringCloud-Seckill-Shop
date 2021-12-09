package cn.heshw.constant;

public enum EntityIDPrefix {
  SKU("SKU"), SPU("SPU"), USER("USR");

  private String prefix;

  EntityIDPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }
}