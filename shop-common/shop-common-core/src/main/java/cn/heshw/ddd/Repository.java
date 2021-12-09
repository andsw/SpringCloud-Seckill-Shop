package cn.heshw.ddd;

public interface Repository<T extends Entity> {

  T find(String entityId);

  /**
   * contains both insert and update features.
   * @param domain
   */
  void save(T domain);

  void remove(String entityId);
}