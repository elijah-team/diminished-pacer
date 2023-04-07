package tripleo.elijah.lang;

import java.util.List;

import antlr.Token;
import tripleo.elijah.lang.VariableReference.VR_Parts;

public interface IExprGen {

	void assignment(AbstractBinaryExpression abstractBinaryExpression, IExpression left, IExpression right);

	void variableReference(VariableReference variableReference, String name,
			List<VR_Parts> parts);

	void numericExpression(NumericExpression numericExpression, Token n);

}
