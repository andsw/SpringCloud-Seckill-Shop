package cn.heshw.ddd;

public interface Repository<IDType, T extends Entity<IDType, T>> {

  T find(IDType id);

  /**
   * contains both insert and update features.
   * @param domain
   */
  void save(T domain);

  void delete(IDType id);
}