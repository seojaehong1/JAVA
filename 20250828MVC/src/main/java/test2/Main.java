package test2;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {
		
		String handlerClassName = "test2.ByeCommandHandler";
		
		try {
			Class<?> handlerClass = Class.forName(handlerClassName);
		//	CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
			try {
				CommandHandler handlerInstance = (CommandHandler) handlerClass.getDeclaredConstructor().newInstance();
				handlerInstance.execute();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
