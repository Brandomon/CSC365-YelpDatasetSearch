package common;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphDisplay extends JFrame {
    private Point[] vertices;
    private double[][] adjacencyMatrix;

    public GraphDisplay(Point[] pointArray, double[][] adjacencyMatrix) {
        this.vertices = pointArray;
        this.adjacencyMatrix = adjacencyMatrix;
        setTitle("Graph Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw edges
        g2d.setColor(Color.BLACK);
        double threshold = 0.0001; // or whatever threshold value you want to use
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = i + 1; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] > threshold) {
                    Point source = vertices[i];
                    Point destination = vertices[j];
                    g2d.drawLine((int) (source.x * getWidth()), (int) (source.y * getHeight()), 
                                 (int) (destination.x * getWidth()), (int) (destination.y * getHeight()));
                }
            }
        }

        // Draw vertices
        g2d.setColor(Color.RED);
        int vertexSize = 10;
        for (Point point : vertices) {
            g2d.fillOval((int) (point.x * getWidth() - vertexSize / 2), 
                         (int) (point.y * getHeight() - vertexSize / 2), vertexSize, vertexSize);
        }
    }
    
    public static void main(String[] args) {
        // Create a sample graph with points and adjacency matrix
        Point p1 = new Point(5.2, 5.6);
        Point p2 = new Point(1.2, 4.1);
        Point p3 = new Point(2.1, 2.7);
        Point p4 = new Point(3.3, 1.4);
        Point[] points = {p1, p2, p3, p4};
        double[][] adjacencyMatrix = {
                {0, 2, 5, 6},
                {2, 0, 3, 0},
                {1, 3, 0, 0},
                {6, 0, 0, 0}
        };

        // Create and show the graph display window
        GraphDisplay graphDisplay = new GraphDisplay(points, adjacencyMatrix);
    }
}