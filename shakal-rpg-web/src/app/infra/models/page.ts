export interface Page <T>{
    elements: T[],
    currentPageNumber: number,
    totalElements: number,
    totalOfPages: number,
    size: number,
    firts: boolean,
    last:boolean
}