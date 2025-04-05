package _23_graphs.bfs;
//https://leetcode.com/problems/course-schedule/
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the adjacency list for the graph.
        // For each course, we store a list of courses that depend on it.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the graph using the prerequisites.
        // For a prerequisite pair [a, b], b must be taken before a,
        // so we add an edge from b to a.
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Step 2: Calculate the indegree of each node.
        // indegree[i] indicates how many prerequisites course i has.
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 3: Initialize a queue with all nodes having indegree 0.
        // These courses have no prerequisites and can be taken first.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: Process the courses using topological sort.
        // Remove nodes with indegree 0, add them to the topological order,
        // and decrease the indegree of their neighboring courses.
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();  // Remove and return the head of the queue.
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                // If a neighbor now has no prerequisites, add it to the queue.
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Step 5: Check if topological sort is possible.
        // If we processed all courses, there was no cycle, so return true.
        // Otherwise, return false, indicating it's impossible to finish all courses.
        return topo.size() == numCourses;
    }
}
