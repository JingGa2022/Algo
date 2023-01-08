package problem.백준.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import problem.백준.골드.청소년상어_19236.Fish;

public class 청소년상어_19236 {
	static class Shark{
        int x, y, dir, eat;
        public Shark(){

        }
        public Shark(int x, int y, int dir, int eat){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eat = eat;
        }
    }
    static class Fish{
        int x, y, num, dir;
        boolean alive = true;
        public Fish(){}

        public Fish(int x, int y, int num, int dir, boolean alive){
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }
    }

    static int ans = 0;
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dc[] = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        // input
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                Fish f = new Fish();
                f.num = Integer.parseInt(st.nextToken());
                f.dir = Integer.parseInt(st.nextToken()) - 1;
                f.x = i;
                f.y = j;

                fishes.add(f);
                arr[i][j] = f.num;
            }
        }


        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.num - o2.num;
            }
        });

        Fish f = fishes.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, f.dir, f.num);
        f.alive = false;
        arr[0][0] = -1;


        teenShark(arr, shark, fishes);

        System.out.println(ans);
    }

    private static void teenShark(int[][] arr, Shark shark, List<Fish> fishes) {
        if (ans < shark.eat) ans = shark.eat;

        fishes.forEach(e -> moveFish(e, arr, fishes));

        for(int i = 1; i<4; i++){
            int nx = shark.x + dr[shark.dir]*i;
            int ny = shark.y + dc[shark.dir]*i;

            if(nx >= 4 || nx < 0 || ny >= 4 || ny < 0 || arr[nx][ny] <= 0) continue;

            int[][] arrCopy = copyArr(arr);
            List<Fish> fishCopy = copyFishes(fishes);;

            arrCopy[shark.x][shark.y] = 0;
            Fish f = fishCopy.get(arr[nx][ny] -1);
            Shark s = new Shark(f.x, f.y, f.dir, shark.eat + f.num);
            f.alive = false;
            arrCopy[f.x][f.y] = -1;

            teenShark(arrCopy, s, fishCopy);
        }
    }
    private static void moveFish(Fish fish ,int[][] arr, List<Fish> fishes){
        if(!fish.alive) return;

        for(int i = 0; i<8; i++){
            int nd = (fish.dir + i) % 8;
            int nx = fish.x + dr[nd];
            int ny = fish.y + dc[nd];

            if(nx >= 4 || nx < 0 || ny >= 4 || ny < 0 || arr[nx][ny] == -1) continue;

            arr[fish.x][fish.y] = 0;

            if(arr[nx][ny] != 0){
                Fish tmp = fishes.get(arr[nx][ny] - 1);
                tmp.x = fish.x;
                tmp.y = fish.y;
                arr[fish.x][fish.y] = tmp.num;
            }

            fish.x = nx;
            fish.y = ny;
            arr[nx][ny] = fish.num;
            fish.dir = nd;
            return;
        }

    }
        static private int[][] copyArr(int[][] arr){
        int[][] tmp = new int[4][4];
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++) tmp[i][j] = arr[i][j];
        }
        return tmp;
    }
    static private List<Fish> copyFishes(List<Fish> fishes){
        List<Fish> tmp = new ArrayList<>();
        fishes.forEach(e -> tmp.add(new Fish(e.x, e.y, e.num, e.dir, e.alive)));
        return tmp;
    }
}
