package winning;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.tfsIntegration.checkin.PolicyBase;
import org.jetbrains.tfsIntegration.checkin.PolicyContext;
import org.jetbrains.tfsIntegration.checkin.PolicyFailure;
import org.jetbrains.tfsIntegration.checkin.PolicyType;
// This implementation check that names of the files that are checked in match the pattern

/**
 * @author ettingshausen@outlook.com
 */
public class CheckinCommentPolicy extends PolicyBase {

    /// Let's give our policy an ID matching to ID of TFS built-in checkin policy. This way our implementation will
    /// be triggered if this policy was enabled (using Team Explorer)

    private static final String ID = "CheckForCommentsPolicy.CheckForComments";
    private static final String DESCRIPTION = "Checks for non-empty checkin comment";
    private static final String INSTALLATION_INSTRUCTIONS = "This policy is part of CustomCheckinPolicies plugin.";

    private static final PolicyType TYPE = new PolicyType(ID, "Checkin comment", DESCRIPTION, INSTALLATION_INSTRUCTIONS);

    @Override
    //@NotNull
    public PolicyType getPolicyType() {
        return TYPE;
    }

    @Override
    public PolicyFailure[] evaluate(@NotNull PolicyContext policyContext, @NotNull ProgressIndicator progressIndicator) {
        if (policyContext.getCommitMessage() == null || policyContext.getCommitMessage().trim().length() == 0) {
            return new PolicyFailure[]{new PolicyFailure(this, "Check in comment is empty")};
        }
        return NO_FAILURES;
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