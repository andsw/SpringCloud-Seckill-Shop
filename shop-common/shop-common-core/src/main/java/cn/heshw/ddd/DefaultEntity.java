package cn.heshw.ddd;

public abstract class DefaultEntity implements Entity {

  private final String uid;

  @Override
  public String identityId() {
    return uid;
  }

  public <T extends Builder<T>> DefaultEntity(T builder) {
    this.uid = builder.uid;
  }

  public static abstract class Builder<T extends Builder<T>> {

    public String uid;

    @SuppressWarnings("unchecked")
    public T uid(String val) {
      this.uid = val;
      return (T) this;
    }
  }
}