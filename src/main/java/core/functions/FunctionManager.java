package core.functions;

import java.util.ArrayList;

public class FunctionManager {
    public ArrayList<Function> funcList = new ArrayList<Function>();

    public FunctionManager(){

    }

    public void addFunction(Function f){
        funcList.add(f);
    }
}
