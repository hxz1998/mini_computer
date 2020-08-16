package os;

import program.ExecuteResult;
import program.FunctionParameters;
import program.Program;

import java.util.ArrayList;

public interface Computable {
    ExecuteResult compute(ArrayList<Program> programs, FunctionParameters parametersList);
}
