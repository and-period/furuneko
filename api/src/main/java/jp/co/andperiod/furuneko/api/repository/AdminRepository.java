package jp.co.andperiod.furuneko.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.andperiod.furuneko.api.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {}
