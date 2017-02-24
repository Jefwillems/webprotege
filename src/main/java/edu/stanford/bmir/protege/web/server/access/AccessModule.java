package edu.stanford.bmir.protege.web.server.access;

import dagger.Module;
import dagger.Provides;
import edu.stanford.bmir.protege.web.shared.access.BuiltInRole;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 23 Feb 2017
 */
@Module
public class AccessModule {

    @Provides
    @Singleton
    public AccessManager provideAccessManager(AccessManagerMongoDbImpl impl) {
        impl.setAssignedRoles(Subject.forGuestUser(), ApplicationResource.get(), Collections.singletonList(BuiltInRole.PROJECT_CREATOR.getRoleId()));
        impl.setAssignedRoles(Subject.forAnySignedInUser(),
                              ApplicationResource.get(),
                              Arrays.asList(
                                      BuiltInRole.PROJECT_CREATOR.getRoleId()
//                                      BuiltInRole.ACCOUNT_CREATOR.getRoleId(),
//                                      BuiltInRole.PROJECT_UPLOADER.getRoleId()
                              ));
        return impl;
    }

    @Provides
    @Singleton
    public RoleOracle provideRoleOracle() {
        return RoleOracleImpl.get();
    }


}