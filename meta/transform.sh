#!bin/bash
for f in *; do
  `jq -f ../../meta/jq_filter.txt $f > $f.json`;
done;
