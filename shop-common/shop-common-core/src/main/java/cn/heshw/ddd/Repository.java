package cn.heshw.ddd;

public interface Repository<T extends Entity> {

  T find(String id);

  /**
   * contains both insert and update features.
   * @param domain
   */
  void save(T domain);

  void delete(String id);
}