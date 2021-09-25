package mx.unam.ib.ibdata.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;

public interface IbdDatOcurrenceRepository extends PagingAndSortingRepository<IbdDatOcurrenceEntity, String>{
	
	public Optional<IbdDatOcurrenceEntity> findByOccurrenceId(String id);
	
	public List<IbdDatOcurrenceEntity> findByOccurrenceIdAndIdCountry(String id, Integer idCountry);
	
	public List<IbdDatOcurrenceEntity> findAllByIdCountryOrderByOccurrenceIdDesc(Integer idCountry, Pageable pageable);
	
}
