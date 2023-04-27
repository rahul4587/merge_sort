public class MergeSort {
    public static void conquer(int arr[], int startidx, int mid, int endidx) {
        int merged[] = new int[endidx - startidx + 1];

        int idx1 = startidx;
        int idx2 = mid+1;
        int x = 0;
        while(idx1 <= mid && idx2 <= endidx) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while(idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while(idx2 <= endidx) {
            merged[x++] = arr[idx2++];
        }

        for(int i = 0, j = startidx; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
    
    public static void divide(int arr[], int startidx, int endidx) {
        if(startidx >= endidx) {
            return;
        }

        int mid = startidx + (endidx + startidx)/2;
        divide(arr, startidx, mid);
        divide(arr, mid+1, endidx);
        conquer(arr, startidx, mid, endidx); 
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr, 0, n-1);
        for(int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
