package os;

import program.FunctionResult;
import program.FunctionParameters;
import program.Program;

import java.util.ArrayList;

public interface Computable {
    FunctionResult compute(ArrayList<Program> programs, FunctionParameters parametersList);
}
