package mn.erin.sp.domain.project.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Byambajav
 */
public interface MongoProjectRepository extends MongoRepository<MongoProject, String>
{
  Optional<MongoProject> findByCode(String code);
}
