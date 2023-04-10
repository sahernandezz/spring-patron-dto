package com.example.springpatrondto.mapper;

public interface IMapper<I, O> {
    O map(I in);
}

