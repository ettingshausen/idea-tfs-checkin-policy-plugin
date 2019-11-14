package winning;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.tfsIntegration.checkin.PolicyBase;
import org.jetbrains.tfsIntegration.checkin.PolicyContext;
import org.jetbrains.tfsIntegration.checkin.PolicyFailure;
import org.jetbrains.tfsIntegration.checkin.PolicyType;

/**
 * @author ettingshausen@outlook.com
 */
public class WorkItemsPolicy extends PolicyBase {

    private static final String ID = "Microsoft.TeamFoundation.VersionControl.Controls.WorkItemPolicy";
    private static final String DESCRIPTION = "Checks for no tasks checkins";
    private static final String INSTALLATION_INSTRUCTIONS = "This policy is part of CheckinPolicies plugin.";
    private static final PolicyType TYPE = new PolicyType(ID, "Work Items Policy", DESCRIPTION, INSTALLATION_INSTRUCTIONS);

    @Override
    public PolicyType getPolicyType() {
        return TYPE;
    }

    @Override
    public PolicyFailure[] evaluate(@NotNull PolicyContext policyContext, @NotNull ProgressIndicator progressIndicator) {
        return policyContext.getWorkItems() != null && policyContext.getWorkItems().size() != 0 ? NO_FAILURES
                : new PolicyFailure[]{new PolicyFailure(this, "Check-In is not linked with a work item")};
    }

    @Override
    public boolean canEdit() {
        return false;
    }

    @Override
    public boolean edit(Project project) {
        return false;
    }

    @Override
    public void loadState(@NotNull Element element) {

    }

    @Override
    public void saveState(@NotNull Element element) {

    }
}
