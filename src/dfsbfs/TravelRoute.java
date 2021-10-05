package dfsbfs;

import java.util.*;

class Node {
    private final String routeName;
    private final List<Node> nodeList;
    private final Map<String, Integer> ticketMap;

    public Node(String routeName) {
        this.routeName = routeName;
        nodeList = new ArrayList<>();
        ticketMap = new HashMap<>();
    }

    public String getRouteName() {
        return this.routeName;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public Map<String, Integer> getTicketMap() {
        return ticketMap;
    }

    public void incrementTicketMap(String destRouteName) {
        ticketMap.merge(destRouteName, 1, Integer::sum);
    }

    public void addNode(Node node) {
        this.nodeList.add(node);
    }
}

class VisitRecord {
    private final String routeName;
    private final List<String> visitList;
    private final Map<String, Integer> ticketMap;

    public VisitRecord(String routeName, List<String> visitList, Map<String, Integer> ticketMap) {
        this.routeName = routeName;
        this.visitList = visitList;
        this.ticketMap = ticketMap;
    }

    public String getRouteName() {
        return routeName;
    }

    public List<String> getVisitList() {
        return visitList;
    }

    public Map<String, Integer> getTicketMap() {
        return ticketMap;
    }

    public void incrementTicketMap(String destRouteName) {
        ticketMap.merge(destRouteName, 1, Integer::sum);
    }

    public void addVisitList(String visitedRouteName) {
        this.visitList.add(visitedRouteName);
    }

}

public class TravelRoute {

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        Queue<VisitRecord> queue = new LinkedList<>();
        Map<String, Node> routeMap = new HashMap<>();
        for (String[] ticket : tickets) {
            String src = ticket[0];
            String dst = ticket[1];

            Node srcNode = routeMap.get(src) == null ? new Node(src) : routeMap.get(src);
            Node dstNode = routeMap.get(dst) == null ? new Node(dst) : routeMap.get(dst);

            srcNode.addNode(dstNode);
            srcNode.incrementTicketMap(dst);
            routeMap.put(src, srcNode);
            routeMap.put(dst, dstNode);
        }

        List<String> routeList = new ArrayList<>();
        queue.add(new VisitRecord("ICN", new ArrayList<>(), new HashMap<>()));
        while(!queue.isEmpty()) {
            VisitRecord currentRecord = queue.poll();
            currentRecord.addVisitList(currentRecord.getRouteName());
            Node currentNode = routeMap.get(currentRecord.getRouteName());

            if(currentRecord.getVisitList().size() == tickets.length + 1) {
                routeList.add(String.join(",", currentRecord.getVisitList()));
               continue;
            }

            for(String destKey : currentNode.getTicketMap().keySet()) {
                int ticketVisitNum = currentRecord.getTicketMap().get(currentRecord.getRouteName() + "-" + destKey) == null?
                        0 : currentRecord.getTicketMap().get(currentRecord.getRouteName() + "-" + destKey);
                if(ticketVisitNum < currentNode.getTicketMap().get(destKey)) {
                    Map<String, Integer> tempTicketMap = new HashMap<>(currentRecord.getTicketMap());
                    VisitRecord nextRecord = new VisitRecord(destKey, new ArrayList<>(currentRecord.getVisitList()), tempTicketMap);
                    nextRecord.incrementTicketMap(currentRecord.getRouteName() + "-" + destKey);
                    queue.add(nextRecord);
                }
            }
        }
        Collections.sort(routeList);
        answer  = routeList.get(0).split(",");

        return answer;
    }

}
