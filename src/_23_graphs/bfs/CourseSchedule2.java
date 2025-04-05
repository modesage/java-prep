package _23_graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build the adjacency list for the graph.
        // Each index represents a course and stores a list of courses that depend on it.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the graph using the prerequisites.
        // For a pair [a, b], course b is a prerequisite for course a.
        // So, add an edge from b to a.
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            adj.get(pre).add(course);
        }

        // Step 2: Calculate the indegree of each node.
        // indegree[i] counts how many prerequisites course i has.
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Step 3: Initialize a queue with all nodes having indegree 0.
        // These courses can be taken first because they have no prerequisites.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: Process the courses using topological sort.
        // Remove courses from the queue, add them to the topological order,
        // and reduce the indegree of their neighboring courses.
        int[] topo = new int[numCourses];
        int count = 0;  // This will count the number of courses processed.
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[count++] = node;
            // Decrease the indegree of all neighbors.
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                // If a neighbor now has no prerequisites, add it to the queue.
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 5: Check if topological sort is possible.
        // If we processed all courses, then there's no cycle, and we return the order.
        // Otherwise, return an empty array indicating it's impossible to finish all courses.
        if (count == numCourses) {
            return topo;
        } else {
            return new int[0];
        }
    }
}
