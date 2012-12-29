package personal.belun;

public class ClassUnderTesting {
    private Collaborator someCollaborator;

    public void setSomeCollaborator(Collaborator someCollaborator) {
        this.someCollaborator = someCollaborator;
    }

    public void someMethod() {
        someCollaborator.doSomethignWith("whatever");
    }
}
