package com.transfermarket.controller.datastructure;

import com.transfermarket.model.TransferModel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Samir Adhikari
 */

public class Algorithms {
    // Merge Sort for sorting by Age
    public static LinkedList<TransferModel> mergeSortByAge(LinkedList<TransferModel> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        LinkedList<TransferModel> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<TransferModel> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSortByAge(left);
        right = mergeSortByAge(right);

        return mergeByAge(left, right);
    }
    private static LinkedList<TransferModel> mergeByAge(LinkedList<TransferModel> left, LinkedList<TransferModel> right) {
        LinkedList<TransferModel> merged = new LinkedList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getAge() <= right.get(j).getAge()) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
    
    // Selection Sort for sorting by Nationality
    public static LinkedList<TransferModel> selectionSortByNationality(LinkedList<TransferModel> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getNationality().compareTo(list.get(minIndex).getNationality()) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements
            TransferModel temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }

        return list;
    }
    
    // Insertion Sort for sorting by Goal Contributions
    public static LinkedList<TransferModel> insertionSortByGoalContribution(LinkedList<TransferModel> list) {
        for (int i = 1; i < list.size(); i++) {
            TransferModel key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getGoalContribution() > key.getGoalContribution()) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        return list;
    }
    // Binary Search Method for Nationality
    public static int binarySearchByNationality(LinkedList<TransferModel> transferList, String targetNationality) {
        int low = 0;
        int high = transferList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midNationality = transferList.get(mid).getNationality();

            if (midNationality.compareToIgnoreCase(targetNationality) == 0) {
                return mid; // Found
            } else if (midNationality.compareToIgnoreCase(targetNationality) < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }
    
    
}
    





