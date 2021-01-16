package ui.windows;

import model.game_running.listeners.SaveSessionListener;
import services.database.IDatabase;
import services.database.LocalDBAdapter;
import services.database.MongoDBAdapter;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SaveSessionWindow extends JFrame implements SaveSessionListener {

    private final RunningWindow context;

    public SaveSessionWindow(RunningWindow context) {
        super("Load Session");
        this.context = context;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setContentPane(new JPanel());

        initialize();
        this.pack(); // Pack the frame around the components
        this.setLocationRelativeTo(null); // Center the blender frame
    }

    public void initialize() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                context.setFocusableWindowState(true);
                context.toFront();
            }
        });

        JButton localSaveButton = new JButton("Save Locally");
        JButton onlineSaveButton = new JButton("Save Online");

        localSaveButton.addActionListener(e -> saveMethodSelected(LocalDBAdapter.getInstance()));
        onlineSaveButton.addActionListener(e -> saveMethodSelected(MongoDBAdapter.getInstance()));

        getContentPane().add(localSaveButton);
        getContentPane().add(onlineSaveButton);
    }

    private void saveMethodSelected(IDatabase selectedMethod) {
        context.saveAdapterSelected(selectedMethod);
        context.setFocusableWindowState(true);
        dispose();
    }

    @Override
    public void showSaveMethodSelector() {
        setVisible(true);
        context.setFocusableWindowState(false);
    }
}
