package edu.stanford.bmir.protege.web.server.dispatch;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import edu.stanford.bmir.protege.web.server.app.GetClientApplicationPropertiesActionHandler;
import edu.stanford.bmir.protege.web.server.chgpwd.ResetPasswordActionHandler;
import edu.stanford.bmir.protege.web.server.crud.GetEntityCrudKitSettingsActionHandler;
import edu.stanford.bmir.protege.web.server.crud.GetEntityCrudKitsActionHandler;
import edu.stanford.bmir.protege.web.server.crud.SetEntityCrudKitSettingsActionHandler;
import edu.stanford.bmir.protege.web.server.csv.GetCSVGridActionHandler;
import edu.stanford.bmir.protege.web.server.csv.ImportCSVFileActionHandler;
import edu.stanford.bmir.protege.web.server.dispatch.handlers.*;
import edu.stanford.bmir.protege.web.server.dispatch.validators.UserIsProjectOwnerValidator;
import edu.stanford.bmir.protege.web.server.entities.LookupEntitiesActionHandler;
import edu.stanford.bmir.protege.web.server.events.GetProjectEventsActionHandler;
import edu.stanford.bmir.protege.web.server.frame.*;
import edu.stanford.bmir.protege.web.server.individuals.CreateNamedIndividualsActionHandler;
import edu.stanford.bmir.protege.web.server.individuals.GetIndividualsActionHandler;
import edu.stanford.bmir.protege.web.server.mail.GetEmailAddressActionHandler;
import edu.stanford.bmir.protege.web.server.mail.SetEmailAddressActionHandler;
import edu.stanford.bmir.protege.web.server.metrics.GetMetricsActionHandler;
import edu.stanford.bmir.protege.web.server.notes.AddNoteToEntityActionHandler;
import edu.stanford.bmir.protege.web.server.notes.AddReplyToNoteActionHandler;
import edu.stanford.bmir.protege.web.server.notes.DeleteNoteActionHandler;
import edu.stanford.bmir.protege.web.server.notes.SetNoteStatusActionHandler;
import edu.stanford.bmir.protege.web.server.projectsettings.GetProjectSettingsActionHandler;
import edu.stanford.bmir.protege.web.server.projectsettings.SetProjectSettingsActionHandler;
import edu.stanford.bmir.protege.web.server.render.GetEntityRenderingActionHandler;
import edu.stanford.bmir.protege.web.server.sharing.GetProjectSharingSettingsActionHandler;
import edu.stanford.bmir.protege.web.server.sharing.SetProjectSharingSettingsActionHandler;
import edu.stanford.bmir.protege.web.server.usage.GetUsageActionHandler;
import edu.stanford.bmir.protege.web.server.user.GetUserIdsActionHandler;
import edu.stanford.bmir.protege.web.server.watches.AddWatchActionHandler;
import edu.stanford.bmir.protege.web.server.watches.RemoveWatchActionHandler;
import edu.stanford.bmir.protege.web.shared.sharing.GetProjectSharingSettingsAction;
import edu.stanford.bmir.protege.web.shared.sharing.SetProjectSharingSettingsAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 06/02/15
 */
public class ActionHandlersModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<ActionHandler> multibinder = Multibinder.newSetBinder(binder(), ActionHandler.class);
        multibinder.addBinding().to(GetClientApplicationPropertiesActionHandler.class);
        multibinder.addBinding().to(GetUserIdsActionHandler.class);

        multibinder.addBinding().to(GetAvailableProjectsHandler.class);
        multibinder.addBinding().to(LoadProjectActionHandler.class);

        multibinder.addBinding().to(GetProjectEventsActionHandler.class);

        multibinder.addBinding().to(GetProjectSettingsActionHandler.class);
        multibinder.addBinding().to(SetProjectSettingsActionHandler.class);

        multibinder.addBinding().to(GetClassFrameActionHandler.class);
        multibinder.addBinding().to(UpdateClassFrameActionHandler.class);

        multibinder.addBinding().to(GetObjectPropertyFrameActionHandler.class);
        multibinder.addBinding().to(UpdateObjectPropertyFrameHandler.class);

        multibinder.addBinding().to(GetDataPropertyFrameActionHandler.class);
        multibinder.addBinding().to(UpdateDataPropertyFrameHandler.class);

        multibinder.addBinding().to(GetAnnotationPropertyFrameActionHandler.class);
        multibinder.addBinding().to(UpdateAnnotationPropertyFrameActionHandler.class);

        multibinder.addBinding().to(GetNamedIndividualFrameActionHandler.class);
        multibinder.addBinding().to(UpdateNamedIndividualFrameHandler.class);

        multibinder.addBinding().to(GetRootOntologyIdActionHandler.class);
        multibinder.addBinding().to(GetOntologyAnnotationsActionHandler.class);
        multibinder.addBinding().to(SetOntologyAnnotationsActionHandler.class);
        multibinder.addBinding().to(GetEntityAnnotationsActionHandler.class);

        multibinder.addBinding().to(DeleteEntityActionHandler.class);

        multibinder.addBinding().to(CreateClassActionHandler.class);
        multibinder.addBinding().to(CreateClassesActionHandler.class);
        multibinder.addBinding().to(CreateObjectPropertyActionHandler.class);
        multibinder.addBinding().to(CreateDataPropertiesActionHandler.class);
        multibinder.addBinding().to(CreateAnnotationPropertiesActionHandler.class);
        multibinder.addBinding().to(CreateNamedIndividualsActionHandler.class);

        multibinder.addBinding().to(LookupEntitiesActionHandler.class);

        multibinder.addBinding().to(AddWatchActionHandler.class);
        multibinder.addBinding().to(RemoveWatchActionHandler.class);

        multibinder.addBinding().to(GetCurrentUserInSessionActionHandler.class);
        multibinder.addBinding().to(SetEmailAddressActionHandler.class);
        multibinder.addBinding().to(GetEmailAddressActionHandler.class);

        multibinder.addBinding().to(GetDiscussionThreadActionHandler.class);
        multibinder.addBinding().to(AddNoteToEntityActionHandler.class);
        multibinder.addBinding().to(AddReplyToNoteActionHandler.class);
        multibinder.addBinding().to(SetNoteStatusActionHandler.class);
        multibinder.addBinding().to(DeleteNoteActionHandler.class);

        multibinder.addBinding().to(MoveProjectsToTrashActionHandler.class);
        multibinder.addBinding().to(RemoveProjectsFromTrashActionHandler.class);

        multibinder.addBinding().to(GetCSVGridActionHandler.class);
        multibinder.addBinding().to(ImportCSVFileActionHandler.class);

        multibinder.addBinding().to(GetUsageActionHandler.class);

        multibinder.addBinding().to(GetIndividualsActionHandler.class);

        multibinder.addBinding().to(GetEntityRenderingActionHandler.class);

        multibinder.addBinding().to(GetMetricsActionHandler.class);

        multibinder.addBinding().to(GetEntityCrudKitsActionHandler.class);
        multibinder.addBinding().to(SetEntityCrudKitSettingsActionHandler.class);
        multibinder.addBinding().to(GetEntityCrudKitSettingsActionHandler.class);

        multibinder.addBinding().to(GetManchesterSyntaxFrameActionHandler.class);
        multibinder.addBinding().to(SetManchesterSyntaxFrameActionHandler.class);
        multibinder.addBinding().to(CheckManchesterSyntaxFrameActionHandler.class);
        multibinder.addBinding().to(GetManchesterSyntaxFrameCompletionsActionHandler.class);

        multibinder.addBinding().to(ResetPasswordActionHandler.class);

        multibinder.addBinding().to(GetProjectSharingSettingsActionHandler.class);

        multibinder.addBinding().to(SetProjectSharingSettingsActionHandler.class);





    }
}