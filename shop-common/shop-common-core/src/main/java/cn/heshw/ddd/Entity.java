package cn.heshw.ddd;

public interface Entity<IDType, T> {
  IDType identity();

  boolean sameIdentityAs(T other);
}