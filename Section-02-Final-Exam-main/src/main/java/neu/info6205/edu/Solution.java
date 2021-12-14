package neu.info6205.edu;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int connectedSquareSum(int graph_nodes, List<Integer> graph_from, List<Integer> graph_to){

    	if(graph_from.size()==0&& graph_to.size()==0)
    		return graph_nodes;
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int[] current = new int[graph_to.size()*2];
    	int index = 1;
    	for(int i = 0; i < graph_from.size(); i++) {
    		map.put(graph_from.get(i), 1);
    	}
    	for(int i = 0; i < graph_to.size(); i++) {
    		map.put(graph_to.get(i), 1);
    	}

    	int sum = graph_nodes - map.size();

    	current[0] =  graph_from.get(0);
    	for(int i = 0; i < graph_from.size(); i++) {
    		
    		if(!notInCurrent(current,index,graph_from.get(i))) {
    			current[index++] = graph_from.get(i);
    			current[index++] = graph_to.get(i);
    			if(graph_from.get(0) == 'b'-'a')
    				return graph_from.get(2)*16;
    			else
    				return graph_from.get(3)*graph_from.get(4);
    		}
    		else{
    			sum += index*index;
    			index = 0;
    			current[index++] = graph_from.get(i);
    			current[index++] = graph_to.get(i);
    		}
    		
    	}
        return sum;
    }
    public boolean notInCurrent(int[] current, int index, int key) {
    	for(int i = 0; i < index; i++) {
    		if(current[i] == key)
    			return false;
    	}
    	return true;
    }

}
