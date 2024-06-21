package prr.app.clients;

import prr.Network;
import prr.app.exceptions.UnknownClientKeyException;
import prr.exceptions.Cores_UnknownClientKeyException;
import prr.exceptions.Cores_ClientNotificationsAlreadyEnabledException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Enable client notifications.
 */
class DoEnableClientNotifications extends Command<Network> {

	DoEnableClientNotifications(Network receiver) {
		super(Label.ENABLE_CLIENT_NOTIFICATIONS, receiver);
		addStringField("clientKey", Prompt.key());
	}

	@Override
	protected final void execute() throws CommandException {
        try {
			_receiver.enableClientNotification(stringField("clientKey"));
		} catch (Cores_UnknownClientKeyException e) {
			throw new UnknownClientKeyException(stringField("clientKey"));
		} catch (Cores_ClientNotificationsAlreadyEnabledException e) {
			_display.popup(Message.clientNotificationsAlreadyEnabled());
		}
	}
}
