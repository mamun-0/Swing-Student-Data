package FirstPackage;

import ThirdPackage.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;

    public MainFrame(){
        super("BSMRSTU CSE DEPARTMENT");
        setSize(800,600);
        setLayout(new BorderLayout());


        //========Initialization area===========

        //toolBar = new ToolBar();
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());
        controller = new Controller();
        tablePanel = new TablePanel();
        tablePanel.setData(controller.getStudent());
        //=======Menubar Set====
        setJMenuBar(createMenu());
        //=====================
        add(formPanel,BorderLayout.WEST);
        add(tablePanel,BorderLayout.CENTER);

        //================================




        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventListener(FormEvent event) {
                controller.addStudent(event);
                tablePanel.refresh();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

   private JMenuBar createMenu(){
        JMenuBar menu = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu window = new JMenu("Window");
        menu.add(file);
        menu.add(window);

        JMenuItem importFile = new JMenuItem("Import..");
        JMenuItem exportFile = new JMenuItem("Export..");
        file.add(importFile);
        file.add(exportFile);
        file.addSeparator();
        JMenuItem exit = new JMenuItem("Exit");
       file.add(exit);
       JMenu show = new JMenu("Show");
       JCheckBoxMenuItem hideForm = new JCheckBoxMenuItem("Check");
       hideForm.setSelected(true);
       show.add(hideForm);
       window.add(show);

       tablePanel.setListener(new StudentListener(){

           public void deletedRow(int row){
               controller.removeStudent(row);
           }

       });

       hideForm.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JCheckBoxMenuItem hideRef = (JCheckBoxMenuItem) e.getSource();
               formPanel.setVisible(hideRef.isSelected());
           }
       });

       file.setMnemonic(KeyEvent.VK_F);
       exit.setMnemonic(KeyEvent.VK_X);
       exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
       importFile.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       controller.loadFile(fileChooser.getSelectedFile());
                       tablePanel.refresh();
                   } catch (IOException ex) {
                       JOptionPane.showMessageDialog(MainFrame.this,"Could not load file","Error",JOptionPane.ERROR_MESSAGE);
                   }
               }
           }
       });
       exportFile.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       controller.saveFile(fileChooser.getSelectedFile());
                   } catch (IOException ex) {
                       JOptionPane.showMessageDialog(MainFrame.this,
                               "Could not save file","Error",JOptionPane.ERROR_MESSAGE);

                   }
               }
           }
       });

       exit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int quitConfirm = JOptionPane.showConfirmDialog(MainFrame.this,"Are you sure to quit the application?",
                       "Quit Application",JOptionPane.OK_CANCEL_OPTION);
               if (quitConfirm == JOptionPane.OK_OPTION)
                   System.exit(0);
           }
       });

       return menu;
   }

}
