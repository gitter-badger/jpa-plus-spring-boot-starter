package com.github.yjgbg.jpa.plus.specificationSupport;

import com.github.yjgbg.jpa.plus.entitySupport.StdEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface StdRepository<T extends StdEntity<T>>
    extends JpaSpecificationExecutorPro<T>, Repository<T, Long> {

  // 包含已经逻辑删除的字段
  default ExecutableSpecification<T> specIncludeDeletedLogically() {
    return new ExecutableSpecification<>(this);
  }

  // 不包含已经逻辑删除的字段
  default ExecutableSpecification<T> spec() {
    return new ExecutableSpecification<>(this)
            .eq("deleted",false);
  }
}
