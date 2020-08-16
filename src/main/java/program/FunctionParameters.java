/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package program;

import java.util.HashMap;

public class FunctionParameters {
    private HashMap<Object, Object> parameters;

    public FunctionParameters() {
        this.parameters = new HashMap<>();
    }

    public HashMap getParamList() {
        return parameters;
    }
}
