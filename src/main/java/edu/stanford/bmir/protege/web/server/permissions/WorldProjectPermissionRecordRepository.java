package edu.stanford.bmir.protege.web.server.permissions;

import edu.stanford.bmir.protege.web.shared.permissions.Permission;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 13/03/16
 */
public interface WorldProjectPermissionRecordRepository extends Repository<WorldProjectPermissionRecord, ProjectId> {

    WorldProjectPermissionRecord save(WorldProjectPermissionRecord s);

    Optional<WorldProjectPermissionRecord> findOneByProjectId(ProjectId projectId);

    void deleteAllByProjectId(ProjectId projectId);

    int countByProjectIdAndPermissions(ProjectId projectId, Permission permissions);
}