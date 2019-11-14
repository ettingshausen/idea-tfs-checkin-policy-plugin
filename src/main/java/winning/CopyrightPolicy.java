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
public class CopyrightPolicy extends PolicyBase {

    private static final String ID = "CopyrightCheckinPolicy.CopyrightPolicy";
    private static final String DESCRIPTION = "Checks for non-empty checkin comment";
    private static final String INSTALLATION_INSTRUCTIONS = "This policy is part of CustomCheckinPolicies plugin.";

    private static final PolicyType TYPE = new PolicyType(ID, "Checkin comment", DESCRIPTION, INSTALLATION_INSTRUCTIONS);

    //@NotNull
    @Override
    public PolicyType getPolicyType() {
        return TYPE;
    }

    @Override
    public PolicyFailure[] evaluate(@NotNull PolicyContext policyContext, @NotNull ProgressIndicator progressIndicator) {
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
