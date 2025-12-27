package daily.twentySeventh;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MeetingRoomIII {
    class Solution {
        class Pair implements Comparable {
            int end;
            int room;

            Pair(int end, int room) {
                this.end = end;
                this.room = room;
            }

            @Override
            public int compareTo(Object o) {
                Pair p = (Pair) o;
                int ret = this.end - p.end;
                if (ret == 0) {
                    return this.room - p.room;
                }
                return ret;
            }
        }

        public int mostBooked(int n, int[][] meetings) {
            List<Long> count = Stream.generate(() -> 0L).limit(n).collect(Collectors.toCollection(ArrayList::new));

            List<List<Integer>> sorted = Arrays.stream(meetings).map(a ->
                    Arrays.stream(a).boxed().toList()).collect(Collectors.toCollection(ArrayList::new));
            sorted.sort(Comparator.comparingInt(l -> l.get(0)));
            PriorityQueue<Integer> available = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                available.offer(i);
            }

            PriorityQueue<Pair> used = new PriorityQueue<>();
            for (List<Integer> meet : sorted) {
//                popping out rooms that should be done
                while (!used.isEmpty() && used.peek().end <= meet.get(0)) {
                    Pair p = used.poll();
                    available.offer(p.room);
                }
                int end = meet.get(1);
                int room = -1;
//                dont have room availble, get the next room detials
                if (available.isEmpty()) {
                    int diff = meet.get(1) - meet.get(0);
                    Pair get = used.poll();
                    end = get.end + diff;
                    room = get.room;
                }
//                rooms are available
                else {
                    room = available.poll();
                }

                Pair p = new Pair(end, room);
                used.offer(p);
                count.set(room, count.get(room) + 1);
            }
            int maxI = -1;
            Long max = Long.MIN_VALUE;
            for (int i = count.size() - 1; i >= 0; i--) {
                Long get = count.get(i);
                if (get >= max) {
                    max = get;
                    maxI = i;
                }
            }
            return maxI;

        }
    }
}
