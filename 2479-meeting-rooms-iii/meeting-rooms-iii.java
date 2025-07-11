import java.util.*;

public class Solution {

    static class Pair {
        long endTime;
        int room;

        Pair(long endTime, int room) {
            this.endTime = endTime;
            this.room = room;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        PriorityQueue<Pair> ongoing = new PriorityQueue<>((a, b) -> {
            if (a.endTime != b.endTime) {
                return Long.compare(a.endTime, b.endTime);
            }
            return Integer.compare(a.room, b.room);
        });

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!ongoing.isEmpty() && ongoing.peek().endTime <= start) {
                available.offer(ongoing.poll().room);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                rooms[room]++;
                ongoing.offer(new Pair(end, room));
            } else {
                Pair earliest = ongoing.poll();
                long newEnd = earliest.endTime + (end - start);
                rooms[earliest.room]++;
                ongoing.offer(new Pair(newEnd, earliest.room));
            }
        }

        int maxMeetings = 0;
        int roomIndex = 0;
        for (int i = 0; i < n; i++) {
            if (rooms[i] > maxMeetings) {
                maxMeetings = rooms[i];
                roomIndex = i;
            }
        }

        return roomIndex;
    }

}
