/**
 * Created by Xiaozhong on 2020/8/18.
 * Copyright (c) 2020/8/18 Xiaozhong. All rights reserved.
 */
package program.command;

import program.TerminationResult;

public interface Command {
    TerminationResult execute();
}
