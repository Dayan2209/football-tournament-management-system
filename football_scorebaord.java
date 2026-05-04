import java.util.*;
class football_scoreboard
{
    static Scanner sc=new Scanner(System.in);
    public static void main()
    {
        System.out.println("enter number of teams");
        int n=sc.nextInt();
        sc.nextLine();
        String teams[]=new String[n];
        System.out.println("enter team names");
        for(int i=0;i<n;i++)
            teams[i]=sc.nextLine();
        System.out.println("choose tournament format");
        System.out.println("enter 1 for round robin format and 2 for knockout format");
        int choice=sc.nextInt();
        System.out.println();
        switch(choice)
        {
            case 1:
                roundRobin(teams,n);break;
            case 2:
                knockout(teams,n);break;
            default:
                System.out.println("invalid choice");
        }
    }
    static void roundRobin(String teams[],int n)
    {
        int points[]=new int[n];
        int matches[]=new int[n];
        int goalsf[]=new int[n];
        int goalsa[]=new int[n];
        int wins[]=new int[n];
        int losses[]=new int[n];
        int draws[]=new int[n];
        if(n%2!=0)
        {
            teams=addDummy(teams,n);
            n=n+1;
        }
        points=new int[n];
        matches=new int[n];
        goalsf=new int[n];
        goalsa=new int[n];
        wins=new int[n];
        losses=new int[n];
        draws=new int[n];
        String[][]fixtures=generateFixtures(teams,n);
        String team1[]=new String[fixtures.length];
        String team2[]=new String[fixtures.length];
        for(int i=0;i<fixtures.length;i++)
        {
            team1[i]=fixtures[i][0];
            team2[i]=fixtures[i][1];
        }
        enterResults(teams,n,team1,team2,fixtures.length,points,matches,goalsf,goalsa,wins,losses,draws);
        sortTable(teams,n,points,matches,goalsf,goalsa,wins,losses,draws);
        displayTable(teams,n,points,matches,goalsf,goalsa,wins,losses,draws);
    }
    static String[] addDummy(String teams[],int n)
    {
        String newTeams[]=new String[n+1];
        for(int i=0;i<n;i++)
            newTeams[i]=teams[i];
        newTeams[n]="DUMMY";
        return newTeams;
    }
    static String[][] generateFixtures(String teams[],int n)
    {
        String arr[]=teams.clone();
        int rounds=n-1;
        int maxMatches=(n*(n-1))/2;
        String fixtures[][]=new String[maxMatches][2];
        int k=0;
        System.out.println("======== FIXTURES ========");
        for(int r=0;r<rounds;r++)
        {
            for(int i=0;i<n/2;i++)
            {
                String t1=arr[i],t2=arr[n-1-i];
                if(!(t1.equals("DUMMY")||t2.equals("DUMMY")))
                {
                    System.out.println(t1+" vs "+t2);
                    fixtures[k][0]=t1;
                    fixtures[k][1]=t2;
                    k++;
                }
            }
            rotate(arr,n);
        }
        return Arrays.copyOf(fixtures,k);
    }
    static void rotate(String arr[],int n)
    {
        String last=arr[n-1];
        for(int i=n-1;i>1;i--)
            arr[i]=arr[i-1];
        arr[1]=last;
    }
    static void enterResults(String teams[],int n,String team1[],String team2[],int k,int points[],int matches[],int goalsf[],int goalsa[],int wins[],int losses[],int draws[])
    {
        System.out.println();
        System.out.println("======== ENTER MATCH RESULTS ========");
        for(int z=0;z<k;z++)
        {
            String t1=team1[z],t2=team2[z];
            int i=findIndex(teams,t1),j=findIndex(teams,t2);
            System.out.println("Match : "+t1+" vs "+t2);
            System.out.println("enter goals scored by team "+t1);
            int score1=sc.nextInt();
            System.out.println("enter goals scored by team "+t2);
            int score2=sc.nextInt();
            updateStats(i,j,score1,score2,points,matches,goalsf,goalsa,wins,losses,draws);
            if(score1>score2)
                System.out.println("winner of the match is team "+t1);
            else if(score2>score1)
                System.out.println("winner of the match is team "+t2);
            else
                System.out.println("the match ended in a draw");
            System.out.println();
        }
    }
    static int findIndex(String teams[],String name)
    {
        for(int i=0;i<teams.length;i++)
            if(teams[i].equals(name))
                return i;
        return -1;
    }
    static void updateStats(int i,int j,int score1,int score2,int points[],int matches[],int goalsf[],int goalsa[],int wins[],int losses[],int draws[])
    {
        matches[i]++;matches[j]++;
        goalsf[i]+=score1;goalsa[i]+=score2;
        goalsf[j]+=score2;goalsa[j]+=score1;
        if(score1>score2)
        {
            points[i]+=3;
            wins[i]++;
            losses[j]++;
        }
        else if(score2>score1)
        {
            points[j]+=3;
            wins[j]++;
            losses[i]++;
        }
        else
        {
            points[i]+=1;
            points[j]+=1;
            draws[i]++;
            draws[j]++;
        }
    }
    static void sortTable(String teams[],int n,int points[],int matches[],int goalsf[],int goalsa[],int wins[],int losses[],int draws[])
    {
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
                int gd1=goalsf[j]-goalsa[j];
                int gd2=goalsf[j+1]-goalsa[j+1];
                if(points[j]<points[j+1]||(points[j]==points[j+1]&&gd1<gd2))
                    swapAll(teams,points,matches,goalsf,goalsa,wins,losses,draws,j);
            }
        }
    }
    static void swapAll(String teams[],int points[],int matches[],int goalsf[],int goalsa[],int wins[],int losses[],int draws[],int j)
    {
        String t=teams[j];teams[j]=teams[j+1];teams[j+1]=t;
        int temp;
        
        temp=points[j];
        points[j]=points[j+1];
        points[j+1]=temp;
        
        temp=matches[j];
        matches[j]=matches[j+1];
        matches[j+1]=temp;
        
        temp=goalsf[j];
        goalsf[j]=goalsf[j+1];
        goalsf[j+1]=temp;
        
        temp=goalsa[j];
        goalsa[j]=goalsa[j+1];
        goalsa[j+1]=temp;
        
        temp=wins[j];
        wins[j]=wins[j+1];
        wins[j+1]=temp;
        
        temp=losses[j];
        losses[j]=losses[j+1];
        losses[j+1]=temp;
        
        temp=draws[j];
        draws[j]=draws[j+1];
        draws[j+1]=temp;
    }
    static void displayTable(String teams[],int n,int points[],int matches[],int goalsf[],int goalsa[],int wins[],int losses[],int draws[])
    {
        System.out.println();
        System.out.println("                                        SCOREBOARD");
        for(int i=0;i<n;i++)
        {
            if(teams[i].equals("DUMMY"))
            continue;
            String name=teams[i];
            int space=15-name.length();
            int gd=goalsf[i]-goalsa[i];
            System.out.print((i+1)+". Team "+name);
            for(int p=0;p<space;p++)
                System.out.print(" ");
            System.out.println("Matches : "+matches[i]+"  Wins : "+wins[i]+"  Losses : "+losses[i]+"  Draws : "+draws[i]+"  G/F : "+goalsf[i]+"  G/A : "+goalsa[i]+"  G/D : "+gd+"  Points : "+points[i]);
        }
    }
    static void knockout(String teams[],int n)
    {
        if(n<=0||(n&(n-1))!=0)
        {
            System.out.println("knockout requires number of teams to be a power of 2");
            return;
        }
        int round=1;
        while(n>1)
        {
            System.out.println("======== ROUND "+round+" FIXTURES ========");
            String matches[][]=createMatches(teams,n);
            teams=playMatches(matches,n);
            n=teams.length;
            round++;
        }
        System.out.println();
        System.out.println("WINNERS OF THE TOURNAMENT : team "+teams[0]);
    }
    static String[][] createMatches(String teams[],int n)
    {
        String matches[][]=new String[n/2][2];
        int idx=0;
        for(int i=0;i<n;i+=2)
        {
            matches[idx][0]=teams[i];
            matches[idx][1]=teams[i+1];
            System.out.println(matches[idx][0]+" vs "+matches[idx][1]);
            idx++;
        }
        return matches;
    }
    static String[] playMatches(String matches[][],int n)
    {
        System.out.println("======== ENTER MATCH RESULTS ========");
        String winners[]=new String[matches.length];
        for(int i=0;i<matches.length;i++)
        {
            String t1=matches[i][0],t2=matches[i][1];
            System.out.println("Match : "+t1+" vs "+t2);
            System.out.println("enter goals scored by "+t1);
            int s1=sc.nextInt();
            System.out.println("enter goals scored by "+t2);
            int s2=sc.nextInt();
            while(s1==s2)
            {
                System.out.println("the match went to penalties.enter penalty scores");
                System.out.println("enter goals scored by "+t1);
                s1=sc.nextInt();
                System.out.println("enter goals scored by "+t2);
                s2=sc.nextInt();
            }
            if(s1>s2)
            {
                winners[i]=t1;
                if(n==2)
                System.out.println(t1+" won the tournament");
                else if(n==4)
                System.out.println(t1+" qualified for the final round and "+t2+" got disqualified");
                else if(n==8)
                System.out.println(t1+" qualified for the semi final round and "+t2+" got disqualified");
                else if(n==16)
                System.out.println(t1+" qualified for the quarter final round and "+t2+" got disqualified");
                else if(n==32)
                System.out.println(t1+" qualified for the round of 16 and "+t2+" got disqualified");
                else
                System.out.println(t1+" qualified for the next round and "+t2+" got disqualified");
            }
            else
            {
                winners[i]=t2;
                if(n==2)
                System.out.println(t2+" won the tournament");
                else if(n==4)
                System.out.println(t2+" qualified for the final round and "+t1+" got disqualified");
                else if(n==8)
                System.out.println(t2+" qualified for the semi final round and "+t1+" got disqualified");
                else if(n==16)
                System.out.println(t2+" qualified for the quarter final round and "+t1+" got disqualified");
                else if(n==32)
                System.out.println(t2+" qualified for the round of 16 and "+t1+" got disqualified");
                else
                System.out.println(t2+" qualified for the next round and "+t1+" got disqualified");
            }
            System.out.println();
        }
        return winners;
    }
}
