package ro.ase.csie.cts.seminar10.command;

public class TestCommand {
	
	public static void main(String[] args) {
		
		TaskAsincron autoSave = new TaskToDo(new ModulAutoSave(), "AutoSave", 5);
		TaskAsincron autoUpdate = new TaskToDo(new ModulUpdateClient(), "Update v2", 20);
		
		//un alt thread va parcurge lista si va executa anumite taskuri
		//autoSave.executaTask();
		//autoUpdate.executaTask();
		
		ManagerTaskuri manager = new ManagerTaskuri();
		manager.adaugaTask(autoSave);
		manager.adaugaTask(autoUpdate);
		
		System.out.println("Jocul este activ.\n");
		
		manager.executaTask();
		manager.executaTask();
		
		System.out.println("\nJocul este activ.\n");
	}
}
