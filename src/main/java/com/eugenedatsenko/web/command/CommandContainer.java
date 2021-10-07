package com.eugenedatsenko.web.command;

import com.eugenedatsenko.web.command.admin.*;
import com.eugenedatsenko.web.command.authorization.LoginCommand;
import com.eugenedatsenko.web.command.authorization.LogoutCommand;
import com.eugenedatsenko.web.command.authorization.RegisterCommand;
import com.eugenedatsenko.web.command.user.UpdateAccountCommand;
import com.eugenedatsenko.web.command.user.UpdateAccountPageCommand;
import com.eugenedatsenko.web.command.user.UserAccountCommand;
import com.eugenedatsenko.web.command.user.UserPeriodicalsCommand;
import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private static Map<String, Command> commands = new HashMap<>();

    static {
        // common commands
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("register", new RegisterCommand());
        commands.put("listPeriodicals", new PeriodicalsListCommand());
        commands.put("language", new LanguageCommand());
        commands.put("sortByName", new SortPublicationsByName());
        commands.put("sortByPrice", new SortPublicationsByPrice());
        commands.put("searchByName", new SearchByNameCommand());

        // user commands
        commands.put("userAccount", new UserAccountCommand());
        commands.put("updateAccountPage", new UpdateAccountPageCommand());
        commands.put("updateAccount", new UpdateAccountCommand());
        commands.put("userPeriodicals", new UserPeriodicalsCommand());

        // admin commands
        commands.put("listUsers", new UsersListCommand());
        commands.put("lockUnlockUser", new LockUnlockUserCommand());
        commands.put("insertPagePublication", new AddPublicationPageCommand());
        commands.put("insertPublication", new InsertPublicationCommand());
        commands.put("deletePublication", new DeletePublicationCommand());
        commands.put("editPublication", new EditPublicationCommand());
        commands.put("updatePublication", new UpdatePublicationCommand());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
