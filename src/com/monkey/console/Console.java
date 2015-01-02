package com.monkey.console;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.monkey.console.listener.FrameWindowListener;
import com.monkey.console.listener.MenuBarListener;
import com.monkey.console.monitor.ServerListener;
import com.monkey.util.Const;

public class Console {

	private ServerListener serverListner = null;

	private JFrame frame;

	private final static int FRAME_WIDTH = 950;

	private final static int FRAME_HEIGHT = 600;

	private final static int FRAME_TITLE_HEIGHT = 100;

	public Console(ServerListener serverListner) {
		this.serverListner = serverListner;
		this.init();
	}

	private void initMenu(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();

		JMenu optionMenu = new JMenu("操作");
		JMenuItem startItem = new JMenuItem("启动Monkey服务器");
		JMenuItem shutdownItem = new JMenuItem("关闭Monkey服务器");
		JMenuItem closeItem = new JMenuItem("关闭控制台");
		shutdownItem.addActionListener(new MenuBarListener());
		optionMenu.add(startItem);
		optionMenu.add(shutdownItem);
		optionMenu.add(new JSeparator());
		optionMenu.add(closeItem);
		menuBar.add(optionMenu);

		JMenu logMenu = new JMenu("日志");
		JMenuItem lookLogItem = new JMenuItem("查看日志");
		JMenuItem clearLogItem = new JMenuItem("清除日志");
		logMenu.add(lookLogItem);
		logMenu.add(clearLogItem);
		menuBar.add(logMenu);

		JMenu helpMenu = new JMenu("帮助");
		JMenuItem versionItem = new JMenuItem("版本信息");
		helpMenu.add(versionItem);
		menuBar.add(helpMenu);

		frame.setJMenuBar(menuBar);
	}

	private void initCenter(JFrame frame) {
		JPanel centerPanel = new JPanel();
		centerPanel.setSize(760, FRAME_HEIGHT - FRAME_TITLE_HEIGHT);
		centerPanel.setLocation(190, 0);
		frame.add(centerPanel);
	}

	private void initSouth(JFrame frame) {
		JPanel southPanel = new JPanel();
		southPanel.setSize(760, 40);
		southPanel.setLocation(190, FRAME_HEIGHT - FRAME_TITLE_HEIGHT);
		frame.add(southPanel);
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton btnStatus = new JButton();
		btnStatus.setBackground(Const.SERVICE_FAIL_STATUS_COLOR);
		southPanel.add(btnStatus);
	}

	private void initWest(JFrame frame) {
		JPanel westPanel = new JPanel();
		JTree tree = new JTree();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(" Root1 ");
		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(" Child1 ");
		DefaultMutableTreeNode child11 = new DefaultMutableTreeNode(" Child11 ");
		DefaultMutableTreeNode child111 = new DefaultMutableTreeNode(
				" Child111 ");
		root.add(child1);
		child1.add(child11);
		child11.add(child111);

		DefaultTreeModel model = new DefaultTreeModel(root);
		tree.setModel(model);
		westPanel.setLayout(new GridLayout(1, 1));
		westPanel.add(new JScrollPane(tree));
		westPanel.setSize(190, frame.getHeight());
		frame.add(westPanel);
	}

	private void init() {
		frame = new JFrame("Monkey Console");
		frame.setLayout(null);
		frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		initMenu(frame);
		initCenter(frame);
		initWest(frame);
		initSouth(frame);
		frame.addWindowListener(new FrameWindowListener());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
