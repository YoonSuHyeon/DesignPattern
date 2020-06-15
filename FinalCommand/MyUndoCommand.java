package FinalCommand;

class MyUndoCommand implements ICommand {
    private Receiver receiver;

    MyUndoCommand(Receiver recv) {
        receiver = recv;
    }

    @Override
    public void Do() {
        receiver.performUndo();
    }
}
