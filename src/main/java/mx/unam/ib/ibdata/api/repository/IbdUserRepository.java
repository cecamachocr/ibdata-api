package mx.unam.ib.ibdata.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unam.ib.ibdata.api.model.entity.IbdUserEntity;

public interface IbdUserRepository extends JpaRepository<IbdUserEntity, UUID>{
	
	public List<IbdUserEntity> findByName(String name);
	
	public List<IbdUserEntity> findByNameAndLastName(String name, String lastName);
	
	
}
